import subprocess

#  print('$ nslookup www.python.o#  rg')
#  r = subprocess.call(['nslookup', 'www.python.org'])
#  print('Exit code:', r)

print('$ nslookup')
p = subprocess.Popen(['nslookup'], stdin=subprocess.PIPE,
                     stdout=subprocess.PIPE, stderr=subprocess.PIPE)
output, err = p.communicate(b'set q=mx\npython.org\nexit\n')
print(output.decode('gbk'))
#  print(output)
print('Exit code:', p.returncode)
