create index IX_A794D4D on sms_Branch (groupId, deleted);
create index IX_5E7C4A6D on sms_Branch (name[$COLUMN_LENGTH:75$]);
create index IX_4243E7A2 on sms_Branch (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_C585EEA4 on sms_Branch (uuid_[$COLUMN_LENGTH:75$], groupId);