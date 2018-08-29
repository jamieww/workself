# 导入MySQL驱动:
import mysql.connector

# 注意把password设为你的root口令:
conn = mysql.connector.connect(
    user='root',
    password='jameus0813',
    host='192.168.49.128',
    database='finance',
    auth_plugin='mysql_native_password')
cursor = conn.cursor()

# 创建user表:
#  cursor.execute(
#  'create table user (id varchar(20) primary key, name varchar(20))')
# 插入一行记录，注意MySQL的占位符是%s:
#  cursor.execute('insert into user (id, name) values (%s, %s)', ['1', 'Michael'])
# 提交事务:
#  conn.commit()
#  cursor.close()

# 运行查询:
cursor = conn.cursor()
cursor.execute('select * from user where id = %s', ('1',))
results = cursor.fetchall()
for row in results:
    print('all records from user: %s, %s.' % (row[0], row[1]))

# 关闭Cursor和Connection:
cursor.close()
conn.close()
