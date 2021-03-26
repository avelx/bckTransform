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


firewall-cmd --zone=public --permanent --remove-port=34132/tcp
firewall-cmd --zone=public --permanent --remove-port=33682/tcp
firewall-cmd --zone=public --permanent --remove-port=36498/tcp
firewall-cmd --zone=public --permanent --remove-port=45788/tcp
firewall-cmd --zone=public --permanent --remove-port=38066/tcp

firewall-cmd --zone=public --permanent --add-port=38000/tcp
firewall-cmd --zone=public --permanent --add-port=38010/tcp

firewall-cmd --zone=public --permanent --add-port=51000/tcp
firewall-cmd --zone=public --permanent --add-port=51815/tcp
firewall-cmd --zone=public --permanent --add-port=51800/tcp
firewall-cmd --zone=public --permanent --add-port=51801/tcp
firewall-cmd --zone=public --permanent --add-port=51802/tcp
firewall-cmd --zone=public --permanent --add-port=51803/tcp
firewall-cmd --reload

firewall-cmd --zone=public --permanent --add-port=51810/tcp

firewall-cmd --zone=public --permanent --add-port=4040/tcp
# History Server
firewall-cmd --zone=public --permanent --add-port=18080/tcp

# REST API
firewall-cmd --zone=public --permanent --add-port=6060/tcp

firewall-cmd --zone=public --permanent --add-port=4040/tcp

firewall-cmd --zone=public --permanent --add-port=38010/tcp

firewall-cmd --reload

