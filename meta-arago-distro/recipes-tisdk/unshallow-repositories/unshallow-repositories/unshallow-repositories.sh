#!/bin/bash

# Authors:
#    Franklin Cooper Jr.
# This distribution contains contributions or derivatives under copyright
# as follows:
#
# Copyright (c) 2015, Texas Instruments Incorporated
# All rights reserved.
#
# Redistribution and use in source and binary forms, with or without
# modification, are permitted provided that the following conditions
# are met:
# - Redistributions of source code must retain the above copyright notice,
#   this list of conditions and the following disclaimer.
# - Redistributions in binary form must reproduce the above copyright
#   notice, this list of conditions and the following disclaimer in the
#   documentation and/or other materials provided with the distribution.
# - Neither the name of Texas Instruments nor the names of its
#   contributors may be used to endorse or promote products derived
#   from this software without specific prior written permission.
#
# THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
# "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
# TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
# PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
# CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
# EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
# PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
# PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
# LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
# OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
# ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

install_dir="__SDK_INSTALL_DIR__"

# Find git binary within the host native bin directory
sdk_git_bin="$install_dir/linux-devkit/sysroots/*86*-linux/usr/bin/git"
sdk_git_bin=`which $sdk_git_bin`

if [ "$sdk_git_bin" = "" ]
then
    echo
    echo "Couldn't find the git command within linux-devkit"
    echo "Unable to automatically unshallow git repository"
    echo "If you have git installed and a version higher than 1.8.0.3 ( git --version)"
    echo "You can manually unshallow the Linux git repository by running the below"
    echo "command within the SDK's Linux git repository"
    echo "git fetch --unshallow"
    echo
    exit 1
fi

linux_dir=`find $install_dir/board-support -maxdepth 1 -name "linux*"`
linux=`basename $linux_dir`

if [ -f $linux_dir/.git/shallow ]
then
    echo
    echo "The kernel git repository has been trimmed to reduce the size of the SDK installer"
    echo "in a process called \"shallowing\". This process causes the repository to include"
    echo "only a small fraction of the entire git history. To retrieve the entire git history"
    echo "you must unshallow the repository. This will require internet access and if applicable"
    echo "proper git proxy settings to access the original remote repository. This script will"
    echo "automatically unshallow the Linux repository for you and retrieve its full history."
    echo "Depending on your internet speed this process can take 5+ minutes."
    echo "Would you like to continue (y/n)?"
    echo

    read -p "[ y ] " continueunshallow
    echo

    if [ ! -n "$continueunshallow" ]; then
       continueunshallow="y"
    fi

    if [ "$continueunshallow" != "y" ]; then
        echo "You selected no. Please run script the again when your ready to unshallow the"
        echo "repository."
        exit 0
    fi

    echo "The unshallowing process has begun. For the first couple of minutes you may not see"
    echo "any additional output. This is normal."

    cd $linux_dir

    $sdk_git_bin fetch --unshallow

    if [ "$?" = "0" ]
    then
        echo
        echo "The unshallowing process has been completed. The Linux git repository has been"
        echo "fully restored."
    else
        echo
        echo "Error unshallowing git repository. Please check your internet connection and"
        echo "your git proxy settings."
    fi

    echo

    cd -
else
    echo
    echo "Kernel git repository is not shallow."
    echo "The repository has the full commit history and can be treated as a normal"
    echo "git repository."
    echo
fi
