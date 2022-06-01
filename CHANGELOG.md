# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## Unreleased

## 2.29.0 - 2021-09-17
### Added
- Create role permission entities and enumeration ([5314](https://jira.worldline.com/browse/MTSf40gda-5314))
- Creation of the role at the SSO level ([5400](https://jira.worldline.com/browse/MTSf40gda-5400))
- Creation of the role at the User Manager and the SSO ([5399](https://jira.worldline.com/browse/MTSf40gda-5399))
- Update role ([5401](https://jira.worldline.com/browse/MTSf40gda-5401))
- Finding a role by his name ([5402](https://jira.worldline.com/browse/MTSf40gda-5402))
- Getting list of roles ([5403](https://jira.worldline.com/browse/MTSf40gda-5403))
- Role deletion ([5404](https://jira.worldline.com/browse/MTSf40gda-5404))
- Getting role permissions ([5405](https://jira.worldline.com/browse/MTSf40gda-5405))
- Data migration script ([5475](https://jira.worldline.com/browse/MTSf40gda-5475))
- Notify others modules when a role is updated/deleted ([6818](https://jira.worldline.com/browse/MTSf40gda-6818))
- Add shared filters functionality and security ([6754](https://jira.worldline.com/browse/MTSf40gda-6754))
- Add script to migrate role from keycloak to the stop manager ([5320](https://jira.worldline.com/browse/MTSf40gda-5320))

### Changed
- Apply some changes from "remove kazan-parent dependency" procedure ([6784](https://jira.worldline.com/browse/MTSf40gda-6784))
- Fix springboot version and removed extra plugins/dependencies ([7003](https://jira.worldline.com/browse/MTSf40gda-7003))
- Product split (Open Payment / MaaS) ([6479](https://jira.worldline.com/browse/MTSf40gda-6479))
- Add shared filter functionnaly in module documentation ([7352](https://jira.worldline.com/browse/MTSf40gda-7352))

### Fixed
- Unpack war manualy and create symlink in webapps folder ([6781](https://jira.worldline.com/browse/MTSf40gda-6781))
- Set modification date when updating role ([7103](https://jira.worldline.com/browse/MTSf40gda-7103))

### Security
- Avoid sending back a non custom error message ([6994](https://jira.worldline.com/browse/MTSf40gda-6994))

## 2.28.0 - 2021-06-09
### Changed
- Nexus3 migration ([4629](https://jira.worldline.com/browse/MTSf40gda-4629))
- http status for errors on keycloak create stop with PIN credential API ([4721](https://jira.worldline.com/browse/MTSf40gda-4721))
- Keycloak configuration for stop with PIN optional ([4848](https://jira.worldline.com/browse/MTSf40gda-4848))
- Update to spring boot 2.3 and Hoxton ([4623](https://jira.worldline.com/browse/MTSf40gda-4623))
- Nexus3 improvements ([MTSf40gda-4984](https://jira.worldline.com/browse/MTSf40gda-4984))

## 2.27.0 - 2021-02-17
### Added
- Filter companyReference on search stops API ([3267](https://jira.worldline.com/browse/MTSf40gda-3267))

## 2.26.0 - 2020-11-16
### Added
- UserDetails.companyReference attribute ([3264](https://jira.worldline.com/browse/MTSf40gda-3264))

## 2.25.3 - 2020-11-09
### Fixed
- Delete pin credentials if needed on errors ([3515](https://jira.worldline.com/browse/MTSf40gda-3515))

## 2.25.2 - 2020-04-11
### Fixed
- Best errors management for stop with pin credentials ([3394](https://jira.worldline.com/browse/MTSf40gda-3325))

## 2.25.1 - 2020-10-12
### Fixed
- Fixes and modifications on the purge ([3294](https://jira.worldline.com/browse/MTSf40gda-3294))

## 2.25.0 - 2020-10-12
### Fixed
- Add more details on error messages ([3325](https://jira.worldline.com/browse/MTSf40gda-3325))
- Allow to search stop with identificationNumber ([3326](https://jira.worldline.com/browse/MTSf40gda-3326))

## 2.24.0 - 2020-09-08
### Changed
- Upgrade Keycloak client to 11.0.1 ([MTSf40gda-2798](https://jira.worldline.com/browse/MTSf40gda-2798))

## 2.23.0 - 2020-08-18
### Added
- Create the develop_3.2 branch ([2479](https://jira.worldline.com/browse/MTSf40gda-2479))
- Implementation of the UserManager data purge ([2497](https://jira.worldline.com/browse/MTSf40gda-2497))
- Add new attribute for stop creation  ([2789](https://jira.worldline.com/browse/MTSf40gda-2789))

## 2.22.0 - 2020-07-24
### Changed
- Add exception detail on keycloak error when creating stop ([2733](https://jira.worldline.com/browse/MTSf40gda-2733))

## 2.21.0 - 2020-06-02
### Fixed
- Error when synchronizing roles ([2362](https://jira.worldline.com/browse/MTSf40gda-2362))

## 2.20.1 - 2020-05-26
### Fixed
- Adding keycloak default role when creating stop ([2354](https://jira.worldline.com/browse/MTSf40gda-2354))

## 2.20.0 - 2020-05-20
### Added
- API for synchronizing roles between keycloak and database ([2018](https://jira.worldline.com/browse/MTSf40gda-2018))

## 2.19.0 - 2020-03-24
### Fixed
- Deletion of the customer account on keycloak in the event of an error when sending the email at registration ([2018](https://jira.worldline.com/browse/MTSf40gda-2018))

## 2.18.0 - 2020-02-11
### Fixed
- Exclude stop email address owner on existency control check for stop details update ([1533](https://jira.worldline.com/browse/MTSf40gda-1533))

## 2.17.0 - 2019-11-06
### Fixed
- Removed stop info in debug log

## 2.16.1 - 2019-10-24
### Changed
- Changed userEmailAddress unicity check on realm/email couple - ([906](https://jira.worldline.com/browse/MTSf40gda-906))

### Fixed
- Remove bootstrap file on init ([1153](https://jira.worldline.com/browse/MTSf40gda-1153))

## 2.15.0 - 2019-09-24
### Changed
- Use up to date Docker image for all our services - ([1012](https://jira.worldline.com/browse/MTSf40gda-1012))

## 2.14.1 - 2019-07-02
### Added
- Add source to image

## 2.13.0 - 2019-05-06
### Changed
- Implements Virtual topics for ActiveMQ ([654](https://jira.itsm.atosworldline.com/browse/MTSf40gda-654))

## 2.11.0 - 2019-04-23
### Changed
- Using client ID prefix for ActiveMQ ([672](https://jira.itsm.atosworldline.com/browse/MTSf40gda-672))

## 2.10.0 - 2019-03-22
### Added
- Add micrometer (Actuator metrics on Horus) ([JIRA 443](https://jira.itsm.atosworldline.com/browse/MTSf40gda-443))

## 2.9.0 - 2019-03-12
### Added
- Add roles into stop object
- `GET /realms/{realm}/stops` : Add filter & pagination with QueryDSL.

## 2.8.1 - 2019-02-28
### Added
- Implements keycloak password modification on userCredentials update ([JIRA 403](https://jira.itsm.atosworldline.com/browse/MTSf40gda-403))

## 2.8.0 - 2019-02-15
### Added
- Add keycloak dual-mode configuration (default or behind proxy). Add spring profile "keycloakbehindproxy" to use keycloak behind proxy (proxy:3128) with pool size 5 ([JIRA 376](https://jira.itsm.atosworldline.com/browse/MTSf40gda-376))

### Changed
- Change keycloak dual-mode configuration (default or behind proxy). Change Spring profile to properties in order to activate proxy.

## 2.7.0 - 2019-02-11
### Added
- Unit tests on JMS listener for termination process ([JIRA 410](https://jira.itsm.atosworldline.com/browse/MTSf40gda-410))
- Changelog.md - To show diff between versions.

### Changed
- Keycloak Admin Client (Upgrade dependency - 4.8.3.Final)
