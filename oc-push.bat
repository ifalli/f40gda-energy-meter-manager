set token=%1
set buildname=%2

set HTTPS_PROXY=http://gateway-fr.priv.atos.fr:3128
set NO_PROXY=

oc login https://admin.caas-qlf.svc.meshcore.net --insecure-skip-tls-verify --token=%token%
oc start-build %buildname% --from-dir=.
oc logout