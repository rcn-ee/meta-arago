-include Rules.make

MAKE_JOBS ?= 1
DEVICE_TYPE ?= hs-fs
DEVICE_TYPE_SEC ?= $(DEVICE_TYPE)

#Device Type should be one of hs, hs-fs and gp. Wrong inputs will build for hs-fs
ifneq ($(DEVICE_TYPE_SEC),$(filter $(DEVICE_TYPE_SEC),hs hs-fs gp))
    DEVICE_TYPE_SEC = hs-fs
endif

all: __ALL_TARGETS__
clean: __CLEAN_TARGETS__
install: __INSTALL_TARGETS__
