CREATE TABLE `idp_role` (
  `idp_role_id` int NOT NULL AUTO_INCREMENT,
  `idp_role_name` varchar(15) NOT NULL,
  `idp_role_description` varchar(30) NOT NULL,
  `idp_role_createdate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idp_role_id`),
  UNIQUE KEY `idp_role_id_UNIQUE` (`idp_role_id`),
  UNIQUE KEY `idp_role_name_UNIQUE` (`idp_role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;

CREATE TABLE `idp_user` (
  `DCF_IDP_USER_ID` int NOT NULL AUTO_INCREMENT,
  `DCF_IDP_USER_UNAME` varchar(10) DEFAULT NULL,
  `DCF_IDP_USER_EMAIL` varchar(25) DEFAULT NULL,
  `DCF_IDP_USER_FNAME` varchar(10) DEFAULT NULL,
  `DCF_IDP_USER_MNAME` varchar(10) DEFAULT NULL,
  `DCF_IDP_USER_LNAME` varchar(10) DEFAULT NULL,
  `DCF_IDP_USER_ADDRESS` varchar(45) DEFAULT NULL,
  `DCF_IDP_USER_CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DCF_IDP_USER_CREATE_BY` varchar(10) DEFAULT NULL,
  `DCF_IDP_USER_UPDATE_TIME` datetime DEFAULT NULL,
  `DCF_IDP_USER_UPDATE_BY` varchar(10) DEFAULT NULL,
  `DCF_IDP_USER_DELETE_TIME` datetime DEFAULT NULL,
  `DCF_IDP_USER_DELETE_BY` varchar(10) DEFAULT NULL,
  `DCF_IDP_USER_IS_ACTIVE` tinyint DEFAULT NULL,
  PRIMARY KEY (`DCF_IDP_USER_ID`),
  UNIQUE KEY `DCF_IDP_USER_ID_UNIQUE` (`DCF_IDP_USER_ID`,`DCF_IDP_USER_UNAME`,`DCF_IDP_USER_EMAIL`,`DCF_IDP_USER_CREATE_TIME`,`DCF_IDP_USER_FNAME`,`DCF_IDP_USER_MNAME`,`DCF_IDP_USER_LNAME`,`DCF_IDP_USER_ADDRESS`,`DCF_IDP_USER_IS_ACTIVE`) USING BTREE /*!80000 INVISIBLE */
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COMMENT='User Information ';

CREATE TABLE `idp_user_profile` (
  `idp_user_profile_id` int NOT NULL AUTO_INCREMENT,
  `idp_user_profile_description` varchar(45) DEFAULT NULL,
  `idp_user_profile_createdate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idp_user_profile_id`),
  UNIQUE KEY `ididp_user_profile_id_UNIQUE` (`idp_user_profile_id`),
  UNIQUE KEY `ididp_user_profile_createdate_UNIQUE` (`idp_user_profile_createdate`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

CREATE TABLE `idp_group` (
  `idp_group_id` int NOT NULL AUTO_INCREMENT,
  `idp_group_description` varchar(45) DEFAULT NULL,
  `idp_group_createdate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idp_group_id`),
  UNIQUE KEY `idp_group_id_UNIQUE` (`idp_group_id`),
  UNIQUE KEY `idp_group_createdate_UNIQUE` (`idp_group_createdate`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

CREATE TABLE `idp_group_role` (
  `idp_group_role_id` int NOT NULL AUTO_INCREMENT,
  `idp_group_role_description` varchar(45) DEFAULT NULL,
  `idp_group_role_group_id` int NOT NULL,
  `idp_group_role_role_id` int NOT NULL,
  `idp_group_role_createdate` datetime NOT NULL,
  PRIMARY KEY (`idp_group_role_id`),
  UNIQUE KEY `idp_group_role_id_UNIQUE` (`idp_group_role_id`),
  UNIQUE KEY `idp_group_role_group_id_UNIQUE` (`idp_group_role_group_id`),
  UNIQUE KEY `idp_group_role_role_id_UNIQUE` (`idp_group_role_role_id`),
  UNIQUE KEY `idp_group_role_createdate_UNIQUE` (`idp_group_role_createdate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `idp_user_profile_group` (
  `idp_user_profile_group_id` int NOT NULL AUTO_INCREMENT,
  `idp_user_profile_group_description` varchar(45) DEFAULT NULL,
  `idp_user_profile_group_userprofileid` int NOT NULL,
  `idp_user_profile_group_groupid` int NOT NULL,
  `idp_user_profile_group_createdate` datetime NOT NULL,
  PRIMARY KEY (`idp_user_profile_group_id`),
  UNIQUE KEY `idp_user_profile_group_id_UNIQUE` (`idp_user_profile_group_id`),
  UNIQUE KEY `idp_user_profile_group_userprofileid_UNIQUE` (`idp_user_profile_group_userprofileid`),
  UNIQUE KEY `idp_user_profile_group_createdate_UNIQUE` (`idp_user_profile_group_createdate`),
  UNIQUE KEY `idp_user_profile_group_groupid_UNIQUE` (`idp_user_profile_group_groupid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `idp_user_profile_user` (
  `ididp_user_profile_user_id` int NOT NULL AUTO_INCREMENT,
  `idp_user_profile_user_description` varchar(45) DEFAULT NULL,
  `idp_user_profile_user_profileid` int NOT NULL,
  `idp_user_profile_user_userid` int NOT NULL,
  `idp_user_profile_user_createdate` datetime NOT NULL,
  PRIMARY KEY (`ididp_user_profile_user_id`),
  UNIQUE KEY `ididp_user_profile_user_id_UNIQUE` (`ididp_user_profile_user_id`),
  UNIQUE KEY `idp_user_profile_user_profile_id_UNIQUE` (`idp_user_profile_user_profileid`),
  UNIQUE KEY `idp_user_profile_user_createdate_UNIQUE` (`idp_user_profile_user_createdate`),
  UNIQUE KEY `idp_user_profile_user_userid_UNIQUE` (`idp_user_profile_user_userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
