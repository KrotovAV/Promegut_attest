import datetime

def main(p):
    p = 'D:/GeekBrains\My Git/2 znakomstvo s iazikami/02 python/Python_cours/itog_project/Notebook/notebook.txt'
    with open(p,'r', encoding='utf8') as text:
        text = text.read()
    # text = text.replace(' ','')
    return text

def my_split(text):
    list_text = text.splitlines()
    for i in range(len(list_text)):
        list_text[i] = list_text[i].split('|')
    for i in range(len(list_text)):
        list_text[i][-1] = list_text[i][-1] + '\n'
    return list_text

def show_all(list_list):
    # print(list_list)
    list_b = []
    for j in range(len(list_list[0])):
        # print(max([len(list_list[i][j]) for i in range(len(list_list))]))
        list_b.append(max([len(list_list[i][j]) for i in range(len(list_list))]))
    for i in range(len(list_list)):
        for j in range(len(list_list[i])):
            if list_b[j] != len(list_list[i][j]):
                if j == len(list_list[i]) - 1:
                    list_list[i][-1] = list_list[i][-1][:-1] + ' '*(list_b[j] -len(list_list[i][j])) + list_list[i][-1][-1:]
                else:
                    list_list[i][j] = list_list[i][j]+ ' '*(list_b[j] -len(list_list[i][j]))
    text_str = ''.join(list(map(lambda x: '|'.join(x), list_list)))
    return text_str


def add_note(note_book):
    if note_book =='1 | Выбрать | действие( 1 ) |чтобы |открыть |файл':
        print(note_book)
        return
    c = str(int(note_book[len(note_book)-1][0]) + 1)
    note_book.append([0] * 0)

    match len(c):
        case 1:
            c = '00' + str(c)
        case 2:
            c = '0' + str(c)
        case '3':
            c = str(c)

    note_book[len(note_book)-1].insert(0, c)
    now = datetime.datetime.now()
    note_book[len(note_book)-1].insert(1, now.strftime("%d-%m-%Y %H:%M"))
    return note_book

def search(note_book_list, val, val_search):
    j = int(val) - 1
    res_list = [note_book_list[0]]
    if val == '7':
        for i in range(1, len(note_book_list)):
            for j in range(len(note_book_list[i])):
                if val_search in note_book_list[i][j]:
                    nam_i = i
                    res_list.append(note_book_list[i])
                    break
    else:
        for i in range(1, len(note_book_list)):
            if val_search in note_book_list[i][j]:
                nam_i = i
                res_list.append(note_book_list[i])
    if len(res_list) == 1:
        se = res_list.append([val_search,' Не ',' Найдено ','','',''])
        nam_i = 0
    se = (''.join(list(map(lambda x: '|'.join(x), res_list))))
    return se, nam_i

def renumerate(note_book):
    for i in range(2,len(note_book)):
        c = str(int(note_book[i][0]))
        # print(c)
        # print('l=', len(c))
        match len(c):
            case 1:
                c = '00' + str(c)
            case 2:
                c = '0' + str(c)
            case '3':
                c = str(c)
        note_book[i][0] = c
    return note_book

def record(note_book, pa):
    text_str = ''.join(list(map(lambda x: '|'.join(x), note_book)))
    with open(pa, 'w', encoding='utf8') as file:
        file.write(text_str)