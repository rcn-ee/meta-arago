# Take the top of the tree which is currenlty 4.0.6 plus two patches.
# One of the patches adds error message support which is what we want
TAG = "bab595e38295dcafcfc17a011d3d51f2df1618e6"

# Set the PV to 4.0.6 plus the commit id
PV = "4.0.6+gitr${SRCPV}"

PR_append = "-arago0"
