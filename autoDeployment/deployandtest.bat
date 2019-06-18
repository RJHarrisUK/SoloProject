cd C:\Users\Admin\Desktop\SoloProject &
call mvn package 
ECHO   ---
ECHO By continuing you will deploy this .war file to the location specified. Do you want to continue?
ECHO   ---
pause
cmd /k "cd C:\Users\Admin\Desktop\SoloProject\target & move /y *.war "C:\LocalInstall\Servers\wildfly-10.1.0.Final\standalone\deployments" & cd C:\Users\Admin\Desktop\SoloProject & mvn surefire-report:report & mvn site & cd C:\Users\Admin\Desktop\SoloProject\target\site & xcopy /s /i "C:\Users\Admin\Desktop\SoloProject\target\site" "C:\Users\Admin\Desktop\Latest Report\\%date:/=_%_\\%time::=-%""