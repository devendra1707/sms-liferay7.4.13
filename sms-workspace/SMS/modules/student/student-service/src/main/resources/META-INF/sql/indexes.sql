create index IX_98AC527D on sms_Student (branchId, deleted);
create index IX_82F12E9A on sms_Student (groupId, deleted);
create index IX_519BB1B2 on sms_Student (name[$COLUMN_LENGTH:75$], branchId, semester, deleted);
create index IX_2D4D470F on sms_Student (name[$COLUMN_LENGTH:75$], deleted);
create index IX_BABBC8EF on sms_Student (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_812FBF31 on sms_Student (uuid_[$COLUMN_LENGTH:75$], groupId);