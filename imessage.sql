create table TB_USER(
  id varchar(255) primary key comment '使用uuid',
  name varchar(128) comment '用户名',
  password varchar(255) comment '密码',
  phone varchar(11) comment '手机号码',
  sex int(2) comment '性别',
  description varchar(255) comment '自我描述',
  portrait varchar(255) comment '头像',
  token varchar(255) comment '令牌token',
  lastReceivedAt datetime comment '最后收到消息时间',
  pushId varchar(255) comment '设备Id',
  createAt datetime DEFAULT CURRENT_TIMESTAMP comment '创建时间' ,
  updateAt datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP comment '更新时间'
);

create table TB_USER_FOLLOW(
  id varchar(255) primary key comment '使用uuid',
  alias varchar(255) comment '别名',
  originId varchar(255) comment '关注人Id',
  targetId varchar(255) comment '关注人的Id',
  createAt datetime DEFAULT CURRENT_TIMESTAMP comment '创建时间',
  updateAt datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP comment '更新时间'
);

create table TB_MESSAGE(
  id varchar(255) primary key comment '使用uuid',
  attach varchar(255) comment '附件',
  content text comment '内容',
  groupId varchar(255) comment '群组Id',
  receiverId varchar(255) comment '接收人Id',
  senderId varchar(255) comment '发送人Id' not null ,
  type int(11) comment '消息的类型',
  createdAt datetime DEFAULT CURRENT_TIMESTAMP comment '创建时间',
  updatedAt datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP comment '更新时间'
);

create table TB_GROUP(
  id varchar(255) primary key comment '使用uuid',
  name varchar(255) comment '群名',
  deacription varchar(255) comment '群描述',
  picture varchar(255) comment '群头像',
  ownerId varchar(255) comment '群组创建者',
  createAt datetime DEFAULT CURRENT_TIMESTAMP comment '创建时间',
  updateAt datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP comment '更新时间'
);

create table TB_GROUP_MEMBER(
  id varchar(255) primary key comment '使用uuid',
  alias varchar(255) comment '备注',
  groupId varchar(255) comment '群组Id',
  userId varchar(255) comment '用户Id',
  notifyLevel int(11) comment '消息通知级别',
  permissionType int(11) comment '权限级别',
  createAt datetime DEFAULT CURRENT_TIMESTAMP comment '创建时间',
  updateAt datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP comment '更新时间'
);

create table TB_APPLY(
  id varchar(255) primary key comment '使用uuid',
  applicationId varchar(255) comment '申请者Id',
  targetId varchar(255) comment '申请添加的用户或群Id',
  type int(11) comment '区分是申请添加用户还是群',
  description varchar(255) comment '申请添加说明',
  alias varchar(255) comment '附件',
  createAt datetime DEFAULT CURRENT_TIMESTAMP,
  updateAt datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
);

create table TB_PUSH_HISTORY(
  id varchar(255) primary key comment '使用uuid',
  receiverId varchar(255) comment '收到人Id',
  receiverPushId varchar(255) comment '在不同手机端登录',
  senderId varchar(255) comment '发送者Id',
  entity BLOB comment '存储消息模型',
  entityType int(11) comment '实体类型',
  arrivalAt datetime comment '到达时间',
  createAt datetime DEFAULT CURRENT_TIMESTAMP,
  updateAt datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
);

ALTER TABLE tb_user_follow
  ADD COLUMN create_time timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  ADD COLUMN update_time timestamp NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP AFTER create_time;