@echo off
:: Script para configurar MySQL en XAMPP para acceso remoto en Windows

:: 1. Modificar el archivo my.ini (configuración de MySQL)
set MYSQL_CONFIG="C:\xampp\mysql\bin\my.ini"  :: Cambia esta ruta si tu XAMPP está en otra carpeta
echo Modificando configuración de MySQL para permitir conexiones remotas...

:: Cambiar la configuración de 'bind-address' a '0.0.0.0'
powershell -Command "(Get-Content %MYSQL_CONFIG%) -replace 'bind-address.*', 'bind-address = 0.0.0.0' | Set-Content %MYSQL_CONFIG%"

:: 2. Configurar el firewall para permitir el puerto 3306
echo Abriendo el puerto 3306 en el firewall de Windows...
netsh advfirewall firewall add rule name="MySQL Port 3306" protocol=TCP dir=in localport=3306 action=allow

:: 3. Configurar MySQL para permitir conexiones remotas
echo Configurando MySQL para acceso remoto...
:: Aquí se necesita la contraseña del usuario root para poder hacer el GRANT
mysql -u root -p -e "GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY 'tu_contraseña'; FLUSH PRIVILEGES;"

:: 4. Reiniciar MySQL para aplicar cambios
echo Reiniciando MySQL para aplicar cambios...
C:\xampp\xampp-control.exe restart mysql

echo La configuración de MySQL para acceso remoto ha sido completada.