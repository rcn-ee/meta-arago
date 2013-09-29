# Set extra preferences based on the product branding (AM-SDK, MC-SDK, etc)
# Examples could be different PREFERRED_PROVIDER or PREFERRED_VERSION
# As well as some other configurable aspects or variables
# Please avoid creating multiple versions of the same brand, if possible
# The policy is for the "Core" brand to be the default,
# hence this file is mostly empty and used as a template

# Temporarily disable "sgx" machine feature for ti33x SOC while building
# latest 3.12 integration kernel, until Graphics SDK catches up
MACHINE_FEATURES_ti33x := "${@d.getVar('MACHINE_FEATURES', True).replace('sgx', '')}"
