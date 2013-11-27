DESCRIPTION = "Utilities from Linaro for testing Power Management"
HOMEPAGE = "https://wiki.linaro.org/WorkingGroups/PowerManagement/Resources/TestSuite/PmQa"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

PV = "0.4.4"
PR = "r2"

BRANCH ?= "master"
SRCREV = "fbc2762359b863dfbf4fd0bab1e8abd2a6125ed4"

SRC_URI = "git://git.linaro.org/tools/pm-qa.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"

CFLAGS += "-pthread"

do_compile () {
    # Find all the .c files in this project and build them.  Save the names
    # of these files so we know which to install in the installation step.
    for x in `find . -name "*.c"`
    do
        util=`echo ${x} | sed s/.c$//`
        oe_runmake ${util}
    done
}

do_install () {
    install -d ${D}${bindir}
    install -d ${D}${bindir}/linaro-pm-qa-include

    # Install the compiled binaries
    for x in `find . -name "*.c"`
    do
        util=`echo ${x} | sed s/.c$//`
        util_basename=`basename ${util}`
        install -m 0755 ${util} ${D}${bindir}/${util_basename}
    done

    # Install the helper scripts in the include directory
    for script in `find . -name "*.sh" | grep include`
    do
        # Remove hardcoded relative paths
        sed -i -e 's#..\/utils\/##' ${script}

        script_basename=`basename ${script}`
        install -m 0755 $script ${D}${bindir}/linaro-pm-qa-include/${script_basename}
    done

    # Install the shell scripts NOT in the include directory since those
    # will be installed elsewhere
    for script in `find . -name "*.sh" | grep -v include`
    do
        # if the script includes any helper scripts from the include
        # directory then change the include path to the absolute path
        # and to reflect the install location of the helper scripts.
        sed -i -e "s#source ../include#source ${bindir}/linaro-pm-qa-include#g" ${script}
        # Remove hardcoded relative paths
        sed -i -e 's#..\/utils\/##' ${script}

        script_basename=`basename ${script}`
        install -m 0755 $script ${D}${bindir}/${script_basename}
    done
}
