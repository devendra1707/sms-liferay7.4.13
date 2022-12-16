create index IX_97B6AF03 on lms_common_Translation (groupId, deleted, modelName[$COLUMN_LENGTH:75$], columnName[$COLUMN_LENGTH:75$], languageCode[$COLUMN_LENGTH:2048$], recordId);
create index IX_AC0CB635 on lms_common_Translation (groupId, deleted, modelName[$COLUMN_LENGTH:75$], recordId);
create index IX_E4F00038 on lms_common_Translation (groupId, modelName[$COLUMN_LENGTH:75$], columnName[$COLUMN_LENGTH:75$], languageCode[$COLUMN_LENGTH:2048$], recordId);
create index IX_9DED27C4 on lms_common_Translation (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_9D64CF46 on lms_common_Translation (uuid_[$COLUMN_LENGTH:75$], groupId);