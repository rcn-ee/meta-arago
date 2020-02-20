# Allow checking of required and conflicting MACHINE_FEATURES
#
# ANY_OF_MACHINE_FEATURES:   ensure at least one item on this list is included
#                           in MACHINE_FEATURES.
# REQUIRED_MACHINE_FEATURES: ensure every item on this list is included
#                           in MACHINE_FEATURES.
# CONFLICT_MACHINE_FEATURES: ensure no item in this list is included in
#                           MACHINE_FEATURES.
# Derived from OE-Core distro_features_check.bbclass

python () {
    # Assume at least one var is set.
    machine_features = set((d.getVar('MACHINE_FEATURES') or '').split())

    any_of_machine_features = set((d.getVar('ANY_OF_MACHINE_FEATURES') or '').split())
    if any_of_machine_features:
        if set.isdisjoint(any_of_machine_features, machine_features):
            raise bb.parse.SkipRecipe("one of '%s' needs to be in MACHINE_FEATURES" % ' '.join(any_of_machine_features))

    required_machine_features = set((d.getVar('REQUIRED_MACHINE_FEATURES') or '').split())
    if required_machine_features:
        missing = set.difference(required_machine_features, machine_features)
        if missing:
            raise bb.parse.SkipRecipe("missing required machine feature%s '%s' (not in MACHINE_FEATURES)" % ('s' if len(missing) > 1 else '', ' '.join(missing)))

    conflict_machine_features = set((d.getVar('CONFLICT_MACHINE_FEATURES') or '').split())
    if conflict_machine_features:
        conflicts = set.intersection(conflict_machine_features, machine_features)
        if conflicts:
            raise bb.parse.SkipRecipe("conflicting machine feature%s '%s' (in MACHINE_FEATURES)" % ('s' if len(conflicts) > 1 else '', ' '.join(conflicts)))
}
