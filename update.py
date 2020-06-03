#!/usr/bin/env python3
# -*- coding: UTF-8 -*-

import os
import re


# Operation
# ==============================================


def update_tmp(tmp, src, id, title):
    print(f"Updating tmp for question_{id}. {title}")
    
    src_file = open(src, "r")
    src_content = src_file.read()
    src_file.close()
    
    tmp_content = src_content.replace(f"class Question_{id} {'{'}", "class Solution {")
    tmp_content.replace("package core.acm.leetcode.cn\n","")

    tmp_file = open(tmp, "w")
    tmp_file.write(tmp_content)
    tmp_file.close()


def create_src(src, tmp, id, title):
    print(f"Creating src for question_{id}. {title}")
    tmp_file = open(tmp, "r")
    tmp_content = tmp_file.read()
    tmp_file.close()
    
    src_content = tmp_content.replace("class Solution {", f"class Question_{id} {'{'}")
    src_content = "package core.acm.leetcode.cn\n"+src_content

    src_file = open(src, "w")
    src_file.write(src_content)
    src_file.close()

# Process 
# ==============================================


SRC_DIR= "src/core/acm/leetcode/cn/"
TMP_DIR="tmp/leetcode/editor/cn/"

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
    src_title = f"Question_{question_id}.kt"

    src_file=os.path.join(SRC_DIR,src_title)
    tmp_file=os.path.join(TMP_DIR, item)
    if os.path.exists(src_file):
        update_tmp(tmp_file, src_file, question_id, title)
    else:
        create_src(src_file, tmp_file, question_id, title)