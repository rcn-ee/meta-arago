#!/bin/sh
#Permission is hereby granted, free of charge, to any person obtaining a copy
#of this software and associated documentation files (the "Software"), to deal
#in the Software without restriction, including without limitation the rights
#to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
#copies of the Software, and to permit persons to whom the Software is
#furnished to do so, subject to the following conditions:
#
#The above copyright notice and this permission notice shall be included in
#all copies or substantial portions of the Software.
#
#THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
#IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
#FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
#AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
#LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
#OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
#THE SOFTWARE.

gplv3_packages=""

# find all files with GPLv3 in them that do not also have RLE
# exception listed.
files=`grep License: /var/lib/opkg/info/*.control | grep -i GPLv3 | grep -v RLE | cut -d: -f1 | sort -u`

for i in $files
do
    package=`basename $i | sed s/\.control//`
    gplv3_packages="$gplv3_packages""\t$package\n"
done

if [ "$gplv3_packages" != "" ]
then
# NOTE: Redirecting to STDERR to make sure the output is flushed before
#       anything else prints
cat << EOM 2>&1
***************************************************************
***************************************************************
NOTICE: This file system contains the followin GPLv3 packages:
EOM
    echo -e $gplv3_packages 2>&1
cat << EOM 2>&1
If you do not wish to distribute GPLv3 components please remove
the above packages prior to distribution.  This can be done using
the opkg remove command.  i.e.:
    opkg remove <package>
Where <package> is the name printed in the list above

NOTE: If the package is a dependency of another package you
      will be notified of the dependent packages.  You should
      use the --force-removal-of-dependent-packages option to
      also remove the dependent packages as well
***************************************************************
***************************************************************
EOM
fi
