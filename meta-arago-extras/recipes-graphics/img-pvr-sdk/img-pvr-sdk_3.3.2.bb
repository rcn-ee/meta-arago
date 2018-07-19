DESCRIPTION = "Imagination PowerVR SDK binaries/examples"
LICENSE = "TI-TSPA"
LIC_FILES_CHKSUM = "file://Jacinto6-IMG-PowerVR-SDK-Manifest.pdf;md5=46bcbfc69f8837c339e15fd4a5044a8c"

CLEANBROKEN = "1"

BRANCH = "master"

SRC_URI = "git://git.ti.com/graphics/img-pvr-sdk.git;protocol=git;branch=${BRANCH}"
SRCREV = "f09e59b2467cb0a5b88b6329fe35527cf65ed6e9"

PR = "r11"

COMPATIBLE_MACHINE = "omap-a15|ti43x|ti33x"

S = "${WORKDIR}/git"

do_install () {
    CP_ARGS="-Prf --preserve=mode,timestamps --no-preserve=ownership"
    install -d ${D}/opt/img-powervr-sdk
    cp ${CP_ARGS} ${S}/targetfs/PVRHub ${D}/opt/img-powervr-sdk
    cp ${CP_ARGS} ${S}/targetfs/PVRScopeDeveloper ${D}/opt/img-powervr-sdk

    install -d ${D}${bindir}/SGX/demos/Raw/
    install -d ${D}${bindir}/SGX/demos/Wayland/

    install -m 755 ${S}/targetfs/Examples/Advanced/NullWS/OGLES2ChameleonMan ${D}${bindir}/SGX/demos/Raw/
    install -m 755 ${S}/targetfs/Examples/Advanced/NullWS/OGLES2Coverflow ${D}${bindir}/SGX/demos/Raw/
    install -m 755 ${S}/targetfs/Examples/Advanced/NullWS/OGLES2ExampleUI ${D}${bindir}/SGX/demos/Raw/
    install -m 755 ${S}/targetfs/Examples/Advanced/NullWS/OGLES2Navigation ${D}${bindir}/SGX/demos/Raw/
    install -m 755 ${S}/targetfs/Examples/Advanced/NullWS/OGLES2MagicLantern ${D}${bindir}/SGX/demos/Raw/
    install -m 755 ${S}/targetfs/Examples/Advanced/NullWS/OGLES2FilmTV ${D}${bindir}/SGX/demos/Raw/

    install -m 755 ${S}/targetfs/Examples/Advanced/Wayland/OGLES2ChameleonMan ${D}${bindir}/SGX/demos/Wayland/
    install -m 755 ${S}/targetfs/Examples/Advanced/Wayland/OGLES2Coverflow ${D}${bindir}/SGX/demos/Wayland/
    install -m 755 ${S}/targetfs/Examples/Advanced/Wayland/OGLES2ExampleUI ${D}${bindir}/SGX/demos/Wayland/
    install -m 755 ${S}/targetfs/Examples/Advanced/Wayland/OGLES2Navigation ${D}${bindir}/SGX/demos/Wayland/
    install -m 755 ${S}/targetfs/Examples/Advanced/Wayland/OGLES2MagicLantern ${D}${bindir}/SGX/demos/Wayland/
    install -m 755 ${S}/targetfs/Examples/Advanced/Wayland/OGLES2FilmTV ${D}${bindir}/SGX/demos/Wayland/
}

RDEPENDS_${PN} = "ti-sgx-ddk-um"

INHIBIT_PACKAGE_STRIP = "1"

INSANE_SKIP_${PN} += "dev-so staticdev already-stripped ldflags"

FILES_${PN} += " \
    /opt/img-powervr-sdk/PVRHub/* \
    /opt/img-powervr-sdk/PVRScopeDeveloper/* \
"
