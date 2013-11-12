DESCRIPTION = "Target packages for Qt5 SDK"
LICENSE = "MIT"

PR = "r1"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS_${PN} += " \
        packagegroup-arago-standalone-sdk-target \
        libsqlite3-dev \
        qtbase-mkspecs \
        qtdeclarative-mkspecs \
        qtscript-mkspecs \
        qtwebkit-mkspecs \
        qt3d-mkspecs \
        qtlocation-mkspecs \
        qtsensors-mkspecs \
        qtsvg-mkspecs \
        qtjsbackend-mkspecs \
        qtxmlpatterns-mkspecs \
        qtbase-dev \
        qtdeclarative-dev \
        qtscript-dev \
        qtwebkit-dev \
        qt3d-dev \
        qtlocation-dev \
        qtsensors-dev \
        qtsvg-dev \
        qtjsbackend-dev \
        qtxmlpatterns-dev \
"
