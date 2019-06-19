FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
file://0001-Add-option-to-run-a-test-indefinitely.patch \
file://0001-omap-fix-omap_bo_size-for-tiled-buffers.patch \
file://0002-omap-add-OMAP_BO-flags-to-affect-buffer-allocation.patch \
file://0001-libsync-add-support-for-pre-v4.7-kernels.patch \
file://0002-Add-sync_fence_info-and-sync_pt_info.patch \
"

PR_append = ".arago3"

inherit update-alternatives

ALTERNATIVE_PRIORITY = "10"
ALTERNATIVE_${PN} = "kmstest"
ALTERNATIVE_LINK_NAME[kmstest] = "${bindir}/kmstest"
