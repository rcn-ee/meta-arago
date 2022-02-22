PR:append = ".arago0"

SYSROOT_PREPROCESS_FUNCS:append:class-nativesdk = " llvm_common_sysroot_preprocess"

BBCLASSEXTEND += "nativesdk"
