# In arago.conf, we pre-allocate SDK path very long to reserve enough space in ELF headers
# and then it gets replaced with a short real path at the time of SDK creation:
# SDKPATH_REAL = "/usr/local/${SDK_NAME_PREFIX}-${SDK_VERSION}"
# SDKPATH = "${@"/tmp/"+"x"*96+"/"+"y"*96}"
# Unfortunately, that triggers the new shebang-size QA check in nativesdk-perl packages

python() {
    if d.getVar('CLASSOVERRIDE') == "class-nativesdk":
        pkgs = d.getVar("PACKAGES").split()
        for p in pkgs:
            d.appendVar('INSANE_SKIP:%s' % (p), ' shebang-size')
}
