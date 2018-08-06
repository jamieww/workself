CREATE TABLE
IF NOT EXISTS t_user (
	id INT NOT NULL auto_increment COMMENT '主键',
	code VARCHAR(20) NOT NULL COMMENT '用户编码',
	name varchar(20) DEFAULT '' COMMENT '用户姓名',
  age int(10) DEFAULT 0 COMMENT '年龄',
  amount DECIMAL (14, 2) DEFAULT 0 COMMENT '金额',
  gender INT(1) DEFAULT 0 COMMENT '性别：0.未知 1.男 2.女',
  birthday  DATETIME DEFAULT NULL COMMENT '生日',
  create_time TIMESTAMP DEFAULT current_timestamp COMMENT '创建时间',
  update_time TIMESTAMP DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '修改时间',
	PRIMARY KEY (id),
	UNIQUE KEY UK_code (code)
) ENGINE = INNODB auto_increment = 1 DEFAULT charset = utf8mb4 COMMENT '用户信息表';


