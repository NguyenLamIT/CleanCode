sed -i s/mirror.centos.org/vault.centos.org/g /etc/yum.repos.d/*.repo
sed -i s/^#.*baseurl=http/baseurl=http/g /etc/yum.repos.d/*.repo
sed -i s/^mirrorlist=http/#mirrorlist=http/g /etc/yum.repos.d/*.repo
yum install squid httpd-tools -y
yum install wget -y
/bin/rm -f /etc/squid/squid.conf
/usr/bin/wget -q --no-check-certificate -O /etc/squid/squid.conf https://raw.githubusercontent.com/NguyenLamIT/CleanCode/main/squid.conf
systemctl enable squid
systemctl restart squid
if [ -f /usr/bin/firewall-cmd ]; then
firewall-cmd --zone=public --permanent --add-port=9898/tcp > /dev/null 2>&1
firewall-cmd --reload > /dev/null 2>&1
fi
#htpasswd -c /etc/squid/passwd lamits01
echo -e "Finished creating proxy v4"
