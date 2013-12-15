Należy wywołać polecenie

	mvn compile

aby skompilować projekt. Aplikację zrzucałem na serwer aplikacji Apache Tomcat w wersji 7.0.41.
W pliku tomcat-users.xml dodałem następujące linie:

	<role rolename="tomcat"/>
	<role rolename="manager-gui"/>
	<role rolename="manager-script"/>
	<role rolename="admin-gui"/>
	<user username="tomcat" password="tomcat" roles="tomcat,manager-gui,admin-gui,manager-script"/>

Następnie w pliku settings.xml (w katalogu $HOME/.m2) w gałęzi servers dodałem

	<server>
		<id>tomcatServer</id>
		<username>tomcat</username>
		<password>tomcat</password>
	</server>

Po uruchomieniu serwera (w moim przypadku poleceniem

	sudo /usr/local/apache-tomcat-7.0.41/bin/startup.sh

) można wykonać polecenie

	mvn tomcat7:deploy

aby zrzucić projekt na serwer aplikacji. Po tym można w przeglądarce internetowej wpisać

	http://localhost:8080/api/hello?person=Willson

i powinien pojawić się wynik w postaci

	{"message":"Hello, Willson!"}
