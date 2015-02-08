# MCSDK branding configuration

# Use the MCSDK supported versions
PREFERRED_VERSION_libnl = "3.2.24"

DISTRO_FEATURES += "x11"

# Java preferences.
PREFERRED_VERSION_icedtea7-native = "2.1.3"
PREFERRED_PROVIDER_openjdk-7-jre = "openjdk-7-jre"

PREFERRED_PROVIDER_virtual/java-initial = "cacao-initial"

PREFERRED_PROVIDER_virtual/java-native = "jamvm-native"
PREFERRED_PROVIDER_virtual/javac-native = "ecj-bootstrap-native"

PREFERRED_PROVIDER_jpeg-native = "jpeg-native"
PREFERRED_PROVIDER_glibc-gconv-iso8859-1 = "eglibc-locale"
