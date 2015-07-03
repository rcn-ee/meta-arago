PR_append = "-arago0"

do_install_append () {
    # Allow telnet sessions to login as root
    securetty_file=${D}${sysconfdir}/securetty

    echo '' >> $securetty_file
    echo '# Allow 5 telnet login' >> $securetty_file
    echo 'pts/0' >> $securetty_file
    echo 'pts/1' >> $securetty_file
    echo 'pts/2' >> $securetty_file
    echo 'pts/3' >> $securetty_file
    echo 'pts/4' >> $securetty_file

}
