SRCREV = "c24ed221e9e82faf1ad22de133c3c97a0117c5d7"
PV = "1.9.2"

do_install_append () {
         install -m 0644 ${S}/misc/irqbalance.service ${D}${systemd_unitdir}/system/irqbalanced.service
}

PR_append = ".arago3"
