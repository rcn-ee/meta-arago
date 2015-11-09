PR_append = "-arago0"

# This is a crude workaround to prevent dspdce and ipumm from
# attempting to concurrently rebuild common packages (such as
# fc and ce) in the sysroot.
DEPENDS_append = " \
    ipumm-fw \
"
