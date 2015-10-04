# Install oracle driver to the local repo
mvn install:install-file -Dfile=/Users/mtuzhilov/ojdbc6.jar -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0.4 -Dpackaging=jar

# Setup up a db user
SQL> connect sys as sysdba;
SQL> create user test identified by test;
SQL> grant connect, resource, dba to test;
SQL> grant unlimited tablespace to test;

# Run spring boot with create table option the first time. This will create tables in the db. Comment out this line in the application.properties
spring.jpa.hibernate.ddl-auto=create-drop

# Sample json to post
```
   {
        "subject": {
            "firstName": "Joe1",
            "lastName": "Blow",
            "age": 23,
            "address": {
                "street1": "2345",
                "street2": "rosehill",
                "city": "Kansas City",
                "state": "MO",
                "postalCode": 66234
            }
        },
        "phoneNumbers": [
            {
                "type": "HOME",
                "number": "234234"
            },
            {
                "type": "CELL",
                "number": "34534536"
            }
        ]
    }
```

#resource
http://localhost:8080/authorization