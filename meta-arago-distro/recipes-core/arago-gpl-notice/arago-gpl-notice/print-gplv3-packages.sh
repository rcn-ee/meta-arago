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
    echo "***************************************************************"
    echo "***************************************************************"
    echo "NOTICE: This file system contains the followin GPLv3 packages:"
    echo -e $gplv3_packages
    echo "If you do not wish to distribute GPLv3 components please remove"
    echo "the above packages prior to distribution.  This can be done using"
    echo "the opkg remove command.  i.e.:"
    echo "    opkg remove <package>"
    echo "Where <package> is the name printed in the list above"
    echo ""
    echo "NOTE: If the package is a dependency of another package you"
    echo "      will be notified of the dependent packages.  You should"
    echo "      use the --force-removal-of-dependent-packages option to"
    echo "      also remove the dependent packages as well"
    echo "***************************************************************"
    echo "***************************************************************"
fi
