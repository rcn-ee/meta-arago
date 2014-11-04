# This recipe is not valid when not using accelerated multimedia IP
python __anonymous() {
    features = bb.data.getVar("MACHINE_FEATURES", d, 1)
    pkgn = bb.data.getVar("PN", d, 1)
    if not features:
        return
    if "mmip" not in features:
        raise bb.parse.SkipPackage('%s needs dependencies derived from "mmip" flag in MACHINE_FEATURES' % pkgn)
}
