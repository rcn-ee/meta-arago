DESCRIPTION = "Target packages for Qt Embedded SDK"
LICENSE = "MIT"

PR = "r10"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

QT4_SGX_SUPPORT = "\
        libqt-embeddedopengl4-dev \
        libqt-embeddedpvrqwswsegl4-dev \
"

QT4_DEV = " \
        packagegroup-arago-standalone-sdk-target \
        qt4-embedded-mkspecs \
        libqt-embeddedmultimedia4-dev \
        libqt-embeddedphonon4-dev \
        libqt-embedded3support4-dev \
        libqt-embeddedclucene4-dev \
        libqt-embeddedcore4-dev \
        libqt-embeddeddbus4-dev \
        libqt-embeddeddesignercomponents4-dev \
        libqt-embeddeddesigner4-dev \
        libqt-embeddeduitools4-dev \
        libqt-embeddedgui4-dev \
        libqt-embeddedhelp4-dev \
        libqt-embeddednetwork4-dev \
        libqt-embeddedscript4-dev \
        libqt-embeddedscripttools4-dev \
        libqt-embeddedsql4-dev \
        libqt-embeddedsvg4-dev \
        libqt-embeddedtest4-dev \
        libqt-embeddedwebkit4-dev \
        libqt-embeddedxml4-dev \
        libsqlite3-dev \
        libqt-embeddedxmlpatterns4-dev \
        libqt-embeddedmultimedia4-dev \
        libqt-embeddeddeclarative4-dev \
        ${@base_conditional('ARAGO_QT_PROVIDER', 'qt4-embedded-gles','${QT4_SGX_SUPPORT}', '', d)} \
"

QT5_DEV = " \
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
        qtxmlpatterns-mkspecs \
        qtbase-dev \
        qtdeclarative-dev \
        qtscript-dev \
        qtwebkit-dev \
        qt3d-dev \
        qtlocation-dev \
        qtsensors-dev \
        qtsvg-dev \
        qtxmlpatterns-dev \
        qtquick1-dev \
        qtwebengine-mkspecs \
        qtwebengine-dev \
"

RDEPENDS_${PN} += " \
        ${@base_conditional('QT_PROVIDER', 'qt5', "${QT5_DEV}", "${QT4_DEV}", d)} \
"
