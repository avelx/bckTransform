firewall-cmd --zone=public --permanent --add-port=50020/tcp
firewall-cmd --zone=public --permanent --add-port=50070/tcp
firewall-cmd --zone=public --permanent --add-port=9000/tcp
firewall-cmd --zone=public --permanent --add-port=8020/tcp
firewall-cmd --zone=public --permanent --add-port=9870/tcp
firewall-cmd --zone=public --permanent --add-port=9864/tcp
firewall-cmd --zone=public --permanent --add-port=9866/tcp
firewall-cmd --zone=public --permanent --add-port=9867/tcp
firewall-cmd --zone=public --permanent --add-port=44758/tcp
firewall-cmd --zone=public --permanent --add-port=50010/tcp

firewall-cmd --zone=public --permanent --add-port=8080/tcp
firewall-cmd --zone=public --permanent --add-port=7077/tcp
firewall-cmd --zone=public --permanent --add-port=8081/tcp

firewall-cmd --zone=public --permanent --add-port=34132/tcp
firewall-cmd --reload