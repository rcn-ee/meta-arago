DESCRIPTION = "Submenu packages for Matrix GUI v2"

require matrix-gui-apps-git.inc

# This package does not use a subdirectory as ${S} so we need to
# reset the LIC_FILES_CHKSUM setting from the matrix-gui-apps-git.inc file
LIC_FILES_CHKSUM = "file://LICENSE;md5=6e0ae7214f6c74c149cb25f373057fa9"

PR = "${INC_PR}.20"

# These packages make submenus in matrix and are not architecture specific
inherit allarch

S = "${WORKDIR}/git"

# List of submenus to build packages for
SUBMENUS = " arm_submenu \
             3d_submenu \
             cryptos_submenu \
             display_submenu \
             ethernet_submenu \
             multimedia_submenu \
             power_submenu \
             pru_submenu \
             qt4_submenu \
             settings_submenu \
             usb_submenu \
             wifi_submenu \
             oprofile_submenu \
             utilities_submenu \
             mc_demo_submenu \
             opencl_submenu \
             videoanalytics_submenu \
             machinevision_submenu \
             touch_submenu \
             browser_submenu \
	     hmi_submenu \
             tidl_submenu \
             analytics_submenu \
"

do_install(){
    install -d ${D}${MATRIX_APP_DIR}

    for x in ${SUBMENUS}
    do
        cp -rf ${S}/$x ${D}${MATRIX_APP_DIR}/
    done
}

PACKAGES += " ${PN}-arm \
              ${PN}-3d \
              ${PN}-cryptos \
              ${PN}-display \
              ${PN}-ethernet \
              ${PN}-multimedia \
              ${PN}-power \
              ${PN}-pru \
              ${PN}-qt4 \
              ${PN}-qt5 \
              ${PN}-settings \
              ${PN}-usb \
              ${PN}-wifi \
              ${PN}-oprofile \
              ${PN}-camera \
              ${PN}-utility \
              ${PN}-mc-demo \
              ${PN}-opencl \
              ${PN}-videoanalytics \
              ${PN}-machinevision \
              ${PN}-touch \
              ${PN}-browser \
              ${PN}-hmi \
              ${PN}-tidl \
              ${PN}-analytics \
"

# Make sure app images has been installed
RDEPENDS:${PN} += "matrix-gui-apps-images bash"

# Add the files for each submenu package
FILES:${PN}-arm = "${MATRIX_APP_DIR}/arm_submenu/*"
FILES:${PN}-3d = "${MATRIX_APP_DIR}/3d_submenu/*"
FILES:${PN}-cryptos = "${MATRIX_APP_DIR}/cryptos_submenu/*"
FILES:${PN}-display = "${MATRIX_APP_DIR}/display_submenu/*"
FILES:${PN}-ethernet = "${MATRIX_APP_DIR}/ethernet_submenu/*"
FILES:${PN}-multimedia = "${MATRIX_APP_DIR}/multimedia_submenu/*"
FILES:${PN}-power = "${MATRIX_APP_DIR}/power_submenu/*"
FILES:${PN}-pru = "${MATRIX_APP_DIR}/pru_submenu/*"
FILES:${PN}-qt4 = "${MATRIX_APP_DIR}/qt4_submenu/*"
FILES:${PN}-qt5 = "${MATRIX_APP_DIR}/qt5_submenu/*"
FILES:${PN}-settings = "${MATRIX_APP_DIR}/settings_submenu/*"
FILES:${PN}-usb = "${MATRIX_APP_DIR}/usb_submenu/*"
FILES:${PN}-wifi = "${MATRIX_APP_DIR}/wifi_submenu/*"
FILES:${PN}-oprofile = "${MATRIX_APP_DIR}/oprofile_submenu/*"
FILES:${PN}-camera = "${MATRIX_APP_DIR}/camera_submenu/*"
FILES:${PN}-utility = "${MATRIX_APP_DIR}/utilities_submenu/*"
FILES:${PN}-mc-demo = "${MATRIX_APP_DIR}/mc_demo_submenu/*"
FILES:${PN}-opencl = "${MATRIX_APP_DIR}/opencl_submenu/*"
FILES:${PN}-videoanalytics = "${MATRIX_APP_DIR}/videoanalytics_submenu/*"
FILES:${PN}-machinevision = "${MATRIX_APP_DIR}/machinevision_submenu/*"
FILES:${PN}-touch = "${MATRIX_APP_DIR}/touch_submenu/*"
FILES:${PN}-browser = "${MATRIX_APP_DIR}/browser_submenu/*"
FILES:${PN}-hmi = "${MATRIX_APP_DIR}/hmi_submenu/*"
FILES:${PN}-tidl = "${MATRIX_APP_DIR}/tidl_submenu/*"
FILES:${PN}-analytics = "${MATRIX_APP_DIR}/analytics_submenu/*"
