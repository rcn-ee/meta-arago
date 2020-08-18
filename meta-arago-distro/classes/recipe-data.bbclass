# This class will record certain information about dependent recipes to a conf
# file. This way it can be retrieved by other recipes. For example, this can be
# used to obtain the SRC_URI for the SDK's SW manifest.

# Configuration file to record the recipe data.
RECIPE_DATA_FILE ?= "${TMPDIR}/recipe_data.conf"

# Variables to record
RECIPE_DATA_VARS ?= "PV SRC_URI FILE"


# Helper to load the data from the conf file
def recipe_data_load(d, recipe_data = bb.data.init()):
    fn = d.getVar('RECIPE_DATA_FILE', True)

    if not fn:
        bb.fatal('"RECIPE_DATA_FILE" is not defined!')

    if os.path.exists(fn):
        with bb.utils.fileslocked([fn + '.lock']):
            try:
                bb.parse.handle(fn, recipe_data)
            except Exception as e:
                bb.warn('ERROR parsing "%s"' % fn)
                bb.fatal(str(e))

    return recipe_data


def recipe_data_get_var(var, pn, d):
    if var not in (d.getVar('RECIPE_DATA_VARS', True) or '').split():
        bb.fatal('Variable "%s" was not configured to be recored' % var)

    recipe_data = recipe_data_load(d)
    return recipe_data.getVar('%s_pn-%s' % (var,pn), True)

# Add a shell variety so that it can work in shell tasks
# *** In shell tasks, inline python will be executed during parsing, so shell
# *** variables passed as input.
recipe_data_get_var_sh() {
    local pn="$1"
    local var="$2"

    sed -ne 's|'$var'_pn-'$pn'[ \t]*=[ \t]*"\(.*\)"[ \t]*$|\1|p' ${RECIPE_DATA_FILE}
}

# Update the conf file with a new data.
# Variables such as "FILE" and "TOPDIR" are filtered out by default.
def recipe_data_update(fn, update_data, var_blacklist = ['__.*', 'FILE', 'TOPDIR'], expand = False):
    import re

    recipe_data = bb.data.init()

    # Create the regex to filter out variables
    re_blacklist = re.compile('^' + '$|^'.join(var_blacklist) + '$')
    with bb.utils.fileslocked([fn + '.lock']):
        try:
            bb.parse.handle(fn, recipe_data)
        except:
            pass

        for var in update_data.keys():
            recipe_data.setVar(var, update_data.getVar(var,expand))

        # We could use bb.data_smart's built in "emit_var", but that gives
        # unnecessary comments.
        with open(fn, "w") as f:
            for var in recipe_data.keys():
                if not re_blacklist.match(var):
                    f.write('%s = "%s"\n' % (var, recipe_data.getVar(var,expand)))


addtask emit_recipe_data
do_emit_recipe_data[nostamp] = "1"
python do_emit_recipe_data(){
    recipe_vars = (d.getVar('RECIPE_DATA_VARS', True) or '').split()
    recipe_data_file = d.getVar('RECIPE_DATA_FILE', True)

    pn = d.getVar('PN', True) or bb.fatal('"PN" is not defined!')

    data = bb.data.init()

    # Set pn-${PN} to the overrides for convenience
    data.setVar('OVERRIDES', 'pn-${PN}')
    for var in recipe_vars:
        val = d.getVar(var, True) or ''
        data.setVar('%s_pn-%s' % (var, pn), val)

    recipe_data_update(recipe_data_file, data)
}

# Add empty task to control dependencies
addtask emit_recipe_data_all after do_emit_recipe_data
do_emit_recipe_data_all[noexec] = "1"
do_emit_recipe_data_all[nostamp] = "1"
do_emit_recipe_data_all[recrdeptask] = "do_emit_recipe_data_all do_emit_recipe_data"
do_emit_recipe_data_all[recideptask] = "do_${BB_DEFAULT_TASK}"
do_emit_recipe_data_all() {
    :
}
