GLES_EXTRA_DEPS = ""
GLES_EXTRA_DEPS_omap-a15 = "libdrm wayland"

PACKAGECONFIG[gles2] = "-opengl es2 -eglfs,,virtual/libgles2 virtual/egl ${GLES_EXTRA_DEPS}"

PR_append = "-arago1"

QT_CONFIG_FLAGS += "-qpa wayland"
