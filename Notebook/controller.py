import model
import view

def start_prog():
    view.print_empty()
    # note_book = model.my_split(model.main())
    note_book = '1 | Выбрать | действие( 1 ) |чтобы |открыть |файл'
    note_book = model.my_split(note_book)
    while True:
        view.show_menu()
        var = view.input_value('Выбрать действие ')
        view.print_empty()
        match var:
            case '2':
                view.print_values(model.show_all(note_book))
            case '3':
                note_book = model.add_note(note_book)
                i = 1
                # nenu_sea = ' | 1. №  | 2. Дата созд. | 3. Название | 4. Содержние | 5. Дата время| 6.место| 7. по всем|'
                note_book[len(note_book)-1].insert(i+2, view.input_value('Название - '))
                note_book[len(note_book)-1].insert(i+3, view.input_value('Содержание - '))
                note_book[len(note_book)-1].insert(i+4, view.input_value('Дата Время - '))
                note_book[len(note_book)-1].insert(i+5, view.input_value('Место - '))
        
                view.print_empty()
                # view.print_values(model.show_all(note_book))
            case '4':
                search_string = ''
                view.search_menu()
                search_string, val_i = model.search(note_book,view.input_value('Выбрать номер колонки для поиска '), view.input_value('Что искать? '))
                view.print_empty()
                search_string = model.my_split(search_string)
                view.print_values(model.show_all(search_string))
            case '5': 
                search_string = ''
                view.change_menu()
                var_ch = view.input_value('Выбрать номер колонки для поиска ')
                # view.search_menu()
                match var_ch:
                    case '1':
                        # view.search_menu()
                        search_string, val_i = model.search(note_book,'1', view.input_value('Поиск '))
                    case '2':
                        view.search_menu()
                        search_string, val_i = model.search(note_book,view.input_value('Выбрать номер колонки '), view.input_value('Что искать? '))
                view.print_empty()
                search_string = model.my_split(search_string)
                view.print_values(model.show_all(search_string))

                change = view.input_value('Выбрать "и" для изменения ')
                if change == 'и':
                    # nenu_sea = '                      | 1. №  | 2. Дата созд. | 3. Название | 4. Содержние | 5. Дата события| 6.место| 7. по всем|'
                    note_book[val_i][2] = view.change_value(note_book, val_i, 2, 'Изменить наименование '+ '(' + note_book[val_i][2]+ ')  ')
                    note_book[val_i][3] = view.change_value(note_book, val_i, 3, 'Изменить содержание '+ '(' + note_book[val_i][3]+ ')  ')
                    note_book[val_i][4] = view.change_value(note_book, val_i, 4, 'Изменить дату и время события '+ '(' + note_book[val_i][4]+ ')  ')
                    note_book[val_i][5] = view.change_value(note_book, val_i, 5, 'Изменить место '+ '(' + note_book[val_i][5]+ ')  ') + '\n'
                    # note_book[val_i][6] = note_book[val_i][5][:-1]
                    # note_book[val_i][5] = (view.change_value(note_book, val_i, 5, 'Change note  '+ '(' + note_book[val_i][5]+ ')  ')) + '\n'
                view.print_empty()
                # view.print_values(model.show_all(note_book))
            case '6':
                del_string = ''
                view.change_menu()
                var_ch_del = view.input_value('Выбрать номер для поиска что б удалить ')
                match var_ch_del:
                    case '1':
                        del_string, val_i_del = model.search(note_book,'1', view.input_value('Что искать? '))
                    case '2':
                        view.search_menu()
                        del_string, val_i_del = model.search(note_book,view.input_value('Выбрать номер для поиска колонки '), view.input_value('Что искать? '))
                view.print_empty()
                del_string = model.my_split(del_string)
                view.print_values(model.show_all(del_string))
                delite = view.input_value('Выбрать "у" что бы удалить ')
                view.print_empty()
                if delite == 'у':
                    note_book.pop(val_i_del)
                view.print_empty()
                note_book = model.renumerate(note_book)
                # view.print_values(model.show_all(note_book))
            case '1':
                view.op_menu()
                view.print_empty()
                open_ch  = view.input_value('Выбрать действие что бы открыть файл ')
                match open_ch:
                    case '1':
                        view.print_values('Путь по умолчанию ' + view.default_ope_path)
                        note_book = model.my_split(model.main(view.default_ope_path))
                    case '2':
                        note_book = model.my_split(model.main(view.input_value('Напишите путь что б открыть ')))
                    case '3':
                        view.default_ope_path = view.input_value('Напишите путь для открытия по умочанию ')
                        note_book = model.my_split(model.main(view.default_ope_path))
                view.print_empty()
            case '7':
                view.rec_menu()
                record_ch = view.input_value('Выбрать действие что бы записать файл ')
                match record_ch:
                    case '1':
                        view.print_values('Путь по умолчанию : ' + view.default_rec_path)
                        model.record(note_book, view.default_rec_path)
                    case '2':
                        model.record(note_book, view.default_rec_path(view.input_value('Напишите путь для записи ')))
                    case '3':
                        view.default_rec_path = view.input_value('Напишите путь для записи по умолчанию ')
                        model.record(note_book, view.default_rec_path)
                view.print_empty()
            case '8':
                break



