DESCRIPTION = "Imagination PowerVR SDK binaries/examples"
LICENSE = "TI-TSPA"
LIC_FILES_CHKSUM = "file://Jacinto6-IMG-PowerVR-SDK-Manifest.pdf;md5=46bcbfc69f8837c339e15fd4a5044a8c"

CLEANBROKEN = "1"

BRANCH = "master"

SRC_URI = "git://git.ti.com/graphics/img-pvr-sdk.git;protocol=git;branch=${BRANCH}"
SRCREV = "bb8b74cdd1323e76697b3eb2258f863b15fee287"

PR = "r18"

COMPATIBLE_MACHINE = "omap-a15|ti43x|ti33x|k3"

S = "${WORKDIR}/git"
SRC_DIR = "arm"
SRC_DIR_k3 = "arm64"

do_install () {
    CP_ARGS="-Prf --preserve=mode,timestamps --no-preserve=ownership"
    install -d ${D}/opt/img-powervr-sdk
    cp ${CP_ARGS} ${S}/targetfs/${SRC_DIR}/PVRHub ${D}/opt/img-powervr-sdk
    cp ${CP_ARGS} ${S}/targetfs/${SRC_DIR}/PVRScopeDeveloper ${D}/opt/img-powervr-sdk

    install -d ${D}${bindir}/SGX/demos/Raw/
    install -d ${D}${bindir}/SGX/demos/Wayland/
    install -d ${D}${bindir}/SGX/demos/DRM/

    install -m 755 ${S}/targetfs/${SRC_DIR}/Examples/Advanced/NullWS/OGLES2ChameleonMan ${D}${bindir}/SGX/demos/Raw/
    install -m 755 ${S}/targetfs/${SRC_DIR}/Examples/Advanced/NullWS/OGLES2Coverflow ${D}${bindir}/SGX/demos/Raw/
    install -m 755 ${S}/targetfs/${SRC_DIR}/Examples/Advanced/NullWS/OGLES2ExampleUI ${D}${bindir}/SGX/demos/Raw/
    install -m 755 ${S}/targetfs/${SRC_DIR}/Examples/Advanced/NullWS/OGLES2Navigation ${D}${bindir}/SGX/demos/Raw/
    install -m 755 ${S}/targetfs/${SRC_DIR}/Examples/Advanced/NullWS/OGLES2MagicLantern ${D}${bindir}/SGX/demos/Raw/
    install -m 755 ${S}/targetfs/${SRC_DIR}/Examples/Advanced/NullWS/OGLES2FilmTV ${D}${bindir}/SGX/demos/Raw/

    install -m 755 ${S}/targetfs/${SRC_DIR}/Examples/Advanced/Wayland/OGLES2ChameleonMan ${D}${bindir}/SGX/demos/Wayland/
    install -m 755 ${S}/targetfs/${SRC_DIR}/Examples/Advanced/Wayland/OGLES2Coverflow ${D}${bindir}/SGX/demos/Wayland/
    install -m 755 ${S}/targetfs/${SRC_DIR}/Examples/Advanced/Wayland/OGLES2ExampleUI ${D}${bindir}/SGX/demos/Wayland/
    install -m 755 ${S}/targetfs/${SRC_DIR}/Examples/Advanced/Wayland/OGLES2Navigation ${D}${bindir}/SGX/demos/Wayland/
    install -m 755 ${S}/targetfs/${SRC_DIR}/Examples/Advanced/Wayland/OGLES2MagicLantern ${D}${bindir}/SGX/demos/Wayland/
    install -m 755 ${S}/targetfs/${SRC_DIR}/Examples/Advanced/Wayland/OGLES2FilmTV ${D}${bindir}/SGX/demos/Wayland/

    install -m 755 ${S}/targetfs/${SRC_DIR}/Examples/Advanced/DRM/OGLES2ChameleonMan ${D}${bindir}/SGX/demos/DRM/
    install -m 755 ${S}/targetfs/${SRC_DIR}/Examples/Advanced/DRM/OGLES2Coverflow ${D}${bindir}/SGX/demos/DRM/
    install -m 755 ${S}/targetfs/${SRC_DIR}/Examples/Advanced/DRM/OGLES2ExampleUI ${D}${bindir}/SGX/demos/DRM/
    install -m 755 ${S}/targetfs/${SRC_DIR}/Examples/Advanced/DRM/OGLES2Navigation ${D}${bindir}/SGX/demos/DRM/
    install -m 755 ${S}/targetfs/${SRC_DIR}/Examples/Advanced/DRM/OGLES2MagicLantern ${D}${bindir}/SGX/demos/DRM/
    install -m 755 ${S}/targetfs/${SRC_DIR}/Examples/Advanced/DRM/OGLES2FilmTV ${D}${bindir}/SGX/demos/DRM/
}

do_install_append_j7-evm () {
    install -m 755 ${S}/targetfs/${SRC_DIR}/Examples/Advanced/Wayland/OpenGLESDeferredShading ${D}${bindir}/SGX/demos/Wayland/
    install -m 755 ${S}/targetfs/${SRC_DIR}/Examples/Advanced/Wayland/OpenGLESGaussianBlur ${D}${bindir}/SGX/demos/Wayland/
    install -m 755 ${S}/targetfs/${SRC_DIR}/Examples/Advanced/Wayland/OpenGLESImageBasedLighting ${D}${bindir}/SGX/demos/Wayland/
    install -m 755 ${S}/targetfs/${SRC_DIR}/Examples/Advanced/Wayland/OpenGLESIntroducingPVRCamera ${D}${bindir}/SGX/demos/Wayland/
    install -m 755 ${S}/targetfs/${SRC_DIR}/Examples/Advanced/Wayland/OpenGLESIntroducingPVRUtils ${D}${bindir}/SGX/demos/Wayland/
    install -m 755 ${S}/targetfs/${SRC_DIR}/Examples/Advanced/Wayland/OpenGLESIntroducingUIRenderer ${D}${bindir}/SGX/demos/Wayland/
    install -m 755 ${S}/targetfs/${SRC_DIR}/Examples/Advanced/Wayland/OpenGLESNavigation2D ${D}${bindir}/SGX/demos/Wayland/
    install -m 755 ${S}/targetfs/${SRC_DIR}/Examples/Advanced/Wayland/OpenGLESNavigation3D ${D}${bindir}/SGX/demos/Wayland/
    install -m 755 ${S}/targetfs/${SRC_DIR}/Examples/Advanced/Wayland/OpenGLESParticleSystem ${D}${bindir}/SGX/demos/Wayland/

    cp -r ${S}/targetfs/${SRC_DIR}/Examples/Advanced/Wayland/Assets_OpenGLESDeferredShading ${D}${bindir}/SGX/demos/Wayland/
    cp -r ${S}/targetfs/${SRC_DIR}/Examples/Advanced/Wayland/Assets_OpenGLESGaussianBlur ${D}${bindir}/SGX/demos/Wayland/
    cp -r ${S}/targetfs/${SRC_DIR}/Examples/Advanced/Wayland/Assets_OpenGLESImageBasedLighting ${D}${bindir}/SGX/demos/Wayland/
    cp -r ${S}/targetfs/${SRC_DIR}/Examples/Advanced/Wayland/Assets_OpenGLESIntroducingPVRCamera ${D}${bindir}/SGX/demos/Wayland/
    cp -r ${S}/targetfs/${SRC_DIR}/Examples/Advanced/Wayland/Assets_OpenGLESIntroducingPVRUtils ${D}${bindir}/SGX/demos/Wayland/
    cp -r ${S}/targetfs/${SRC_DIR}/Examples/Advanced/Wayland/Assets_OpenGLESIntroducingUIRenderer ${D}${bindir}/SGX/demos/Wayland/
    cp -r ${S}/targetfs/${SRC_DIR}/Examples/Advanced/Wayland/Assets_OpenGLESNavigation2D ${D}${bindir}/SGX/demos/Wayland/
    cp -r ${S}/targetfs/${SRC_DIR}/Examples/Advanced/Wayland/Assets_OpenGLESNavigation3D ${D}${bindir}/SGX/demos/Wayland/
    cp -r ${S}/targetfs/${SRC_DIR}/Examples/Advanced/Wayland/Assets_OpenGLESParticleSystem ${D}${bindir}/SGX/demos/Wayland/
}


RDEPENDS_${PN} = "ti-sgx-ddk-um"
RDEPENDS_${PN}_j7-evm = "ti-img-rogue-umlibs"

INHIBIT_PACKAGE_STRIP = "1"

INSANE_SKIP_${PN} += "dev-so staticdev already-stripped ldflags file-rdeps"

FILES_${PN} += " \
    /opt/img-powervr-sdk/PVRHub/* \
    /opt/img-powervr-sdk/PVRScopeDeveloper/* \
"
