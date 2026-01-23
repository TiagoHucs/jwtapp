Aplicação configurada para java 1.8


Chamada de login:
```
curl --request POST \
--url 'http://localhost:8080/login?user=admin&password=123' \
--header 'User-Agent: insomnia/12.3.0'
```

Chamada com token:
``` 
curl --request GET \
--url http://localhost:8080/hello \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTc2OTEyODIyMCwiZXhwIjoxNzY5MTMxODIwfQ.iq-wZIrgRgVguEE9lBQXx1RISBUN20fTz5d7eXbK-oA' \
--header 'User-Agent: insomnia/12.3.0'
```