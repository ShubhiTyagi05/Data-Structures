'''
# Read input from stdin and provide input before running code

name = raw_input('What is your name?\n')
print 'Hi, %s.' % name
'''
class Stack:
    def __init__(self):
        self.items = []

    def isEmpty(self):
        return self.items == []

    def push(self, item):
        self.items.append(item)

    def pop(self):
        return self.items.pop()

    def peek(self):
        return self.items[len(self.items)-1]

    def size(self):
        return len(self.items)


t = long(raw_input())
for y in range(0,t):
	s=Stack()
	string = raw_input().split()
	n = int(string[0])
	s.push(string[1])
	for x in range(0,n):
		string = raw_input().split()
		if len(string)>1:
			s.push(string[1])
		else:
			first = s.peek()
			s.pop()
			second=s.peek()
			s.pop()
			s.push(first)
			s.push(second)
	print 'Player '+s.peek()
    
