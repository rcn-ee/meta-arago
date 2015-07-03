require arago-qt4.inc

PR := "${PR}.1"

# Some deps are missing when sgx is not set, skip this package
python __anonymous() {
    features = bb.data.getVar("MACHINE_FEATURES", d, 1)
    if not features:
        return
    if "sgx" not in features:
        raise bb.parse.SkipPackage('qt4-embedded-gles needs dependencies derived from "sgx" flag in MACHINE_FEATURES')
}
