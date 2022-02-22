DESCRIPTION = "Target packages for Qt Embedded SDK"
LICENSE = "MIT"

PR = "r16"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS_${PN} += " \
        packagegroup-arago-standalone-sdk-target \
        libsqlite3-dev \
        qtbase-mkspecs \
        qtdeclarative-mkspecs \
        qtscript-mkspecs \
        qt3d-mkspecs \
        qtlocation-mkspecs \
        qtsensors-mkspecs \
        qtsvg-mkspecs \
        qtxmlpatterns-mkspecs \
        qtbase-dev \
        qtbase-staticdev \
        qtdeclarative-dev \
        qtscript-dev \
        qt3d-dev \
        qtlocation-dev \
        qtsensors-dev \
        qtsvg-dev \
        qtxmlpatterns-dev \
        qtwebkit-mkspecs \
        qtwebkit-dev \
        ${@bb.utils.contains("BBFILE_COLLECTIONS", "meta-python2", "qtwebengine-mkspecs qtwebengine-dev", "", d)} \
        qtserialport-mkspecs \
        qtserialport-dev  \
        qtcharts-mkspecs \
        qtcharts-dev \
"
