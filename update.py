#!/usr/bin/env python3
# -*- coding: UTF-8 -*-

import os
import re


# Operation
# ==============================================

def parse_kt_code(content, replacement):
    
    

def update_tmp(tmp, src):
    print("Updating tmp "+tmp)


def create_src(src, tmp):
    print("Creating src "+src)


# Process 
# ==============================================


SRC_DIR= "src/LeetCode-CN/"
TMP_DIR="tmp/LeetCode-CN/leetcode/editor/cn/"

for item in os.listdir(TMP_DIR):
    if not item.endswith(".kt"):
        continue
    
    question_id = re.search("^\[[0-9]+\]",item)
    if not question_id:
        print(f"Unable to match question id for {item}")
        os._exit(1)
    
    question_id = question_id.group()[1:-1]
    title_start_index = item.find("]")+1
    title = item[title_start_index:-3]
    src_title = f"{question_id}.{title}.kt"

    src_file=os.path.join(SRC_DIR,src_title)
    tmp_file=os.path.join(TMP_DIR, item)
    if os.path.exists(src_file):
        update_tmp(tmp_file, src_file)
    else:
        create_src(src_file, tmp_file)