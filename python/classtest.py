import threading
import sys
from selenium import webdriver
from bs4 import BeautifulSoup
import time

class login(object):
    def __init__(self, name,usename):
        self.name=name
        self.usename = usename

    def loginPoc(self):
     option = webdriver.ChromeOptions()
     option.add_argument('headless')
     chrome_driver = "/home/wzn/Documents/chromedriver"
     browser = webdriver.Chrome(chrome_driver, chrome_options=option)
     # browser1 = webdriver.Chrome(chrome_driver)
     browser.get('http://xxxxx/index.jsp')
     try:
        # if lock.acquire(1):
        print(browser.title)
        print(str(self.usename))
        browser.find_element_by_id('u').send_keys(str(self.usename))

        browser.find_element_by_id('p').send_keys('test2019!')
        h1 = browser.current_window_handle
        js = "window.open('xxxxxx/users/forlogin/')"
        browser.execute_script(js)
        handles = browser.window_handles
        h2 = None
        for handle in handles:
            if handle != h1:
                h2 = handle
        browser.switch_to.window(h2)
        bucket_text = browser.page_source
        soup = BeautifulSoup(bucket_text, "html.parser")
        v = soup.find("challenge").getText()
        browser.switch_to.window(h1)
        browser.find_element_by_id('verifycode').send_keys(v)
        global s_time
        global first
        global fre
        if(first>0):
            s_time = time.time()
            first=0
        browser.find_element_by_id('login_btn').click()

        if ("验证成功" in browser.page_source):
            fre+=1
            print(self.name + " 登录成功")
        else:
            print(self.name + " 登录失败")
        e_time = time.time()

        # ti = e_time - s_time
        # # global all_time
        # # all_time += ti
        print("use {:.5}s".format(e_time - s_time))
     finally:
        browser.close()
        # lock.release()
        # print(self.name)
        # print(self.usename)


class myThread(threading.Thread):  # 线程处理函数
    def __init__(self, name,username):
        threading.Thread.__init__(self);  # 线程类必须的初始化
        self.thread_name = name;  # 将传递过来的name构造到类中的name
        self.username = username;

    def run(self):
        # print(self.username)

        test = login(self.name,  self.username)
        test.loginPoc()


threads = [];
nums=5
pra=int(sys.argv[1])*nums
username = 99900000000+pra
first = 1
s_time = 0
fre = 0
for j in range(0,nums):
    username+=1
    thread = myThread(j,username);
    threads.append(thread);
for t in threads:
    t.start();
for t in threads:
    t.join();

end_time = time.time()
print("tps {:.5}/s".format(nums/ (end_time - s_time)))
print(fre)




