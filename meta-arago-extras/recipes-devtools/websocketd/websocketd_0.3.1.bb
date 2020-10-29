SUMMARY = "Application for routing native applications via websockets"
HOMEPAGE = "http://websocketd.com/"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://src/${GO_IMPORT}/LICENSE;md5=a14d7befdbee1290ac5c472cd85d66f2"

inherit go-mod

GO_IMPORT = "github.com/joewalnes/websocketd"

SRC_URI = "git://${GO_IMPORT}"
SRCREV = "0440211d7862dc76b5f2499d7dfcd4ef6a9c2fa2"

# bitbake only exports proxy variables during fetching, but go handles
# module fetching on its own during compile and needs proxy settings
export http_proxy

# Development package contains all the examples in different languages
INSANE_SKIP_${PN}-dev = "file-rdeps"
