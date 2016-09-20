COMMENT ON COLUMN public.acceptdd.tsaccno  IS 'sdweded';
comment on column public.AccountReg.Municipality_Id is 'Община';
comment on column public.AccountReg.AccountCode is 'Номер на сметка';
comment on column public.AccountReg.LevelAccount is 'Ниво сметка:
1 - раздел
2 - група
3 - подгрупа
4 - синтетична сметка';
comment on column public.AccountReg.AccountName is 'Наименование на сметката/подсметка';
comment on column public.AccountReg.AccountKind is 'Вид на сметка:
1- активна
2- пасивна
3 - активно-пасивна';
comment on column public.AccountReg.IsActive is 'активност:
0 - не
1 - да';
--comment on column public.Act.Resolution_Id is 'Решение';
--comment on column public.Act.DebtSubject_Id is 'При прихващане - Задължение на субекта';
--comment on column public.Act.DocumentType_Id is 'Вид документ';
comment on column public.Act.KindAct is 'Предмет на акт:
10- административно нарушение(АУАН)
11- наказателно постановление
12 - глоба-фиш
21 - прихващане/възстановяване';
comment on column public.Act.TaxSubject_Id is 'Задължен субект';
comment on column public.Act.DocNo is 'Изходящ номер = RegNumber.OutNo_Last+1';
comment on column public.Act.DocDate is 'Дата акт';
comment on column public.Act.Sum is 'Сума акт';
comment on column public.Act.Note is 'Забележка';
comment on column public.Act.Verify_date is 'Дата потвърждаване';
comment on column public.Act.Verify_user_Id is 'Потвърдил Потребител';
--comment on column public.Act.DocNo_Ext is 'Изх.Ном.  - външен';
--comment on column public.Act.DocDate_Ext is 'Дата на Изх.Ном.  - външен';
comment on column public.Act.Deliver_Date is 'Дата връчване';
comment on column public.Act.Deliver_user_Id is 'Служител, връчил акт';
comment on column public.Act.user_Id is 'Потребител генерирал акт';
comment on column public.Act.User_date is 'Дата генериране';

--comment on column public.Action.ActionDate is 'Дата предприемане на мерка /възлагане/';
comment on column public.Action.KindAction is 'Вид предприета мерка';
comment on column public.Action.Exec_Date is 'Дата изпълнение на мерка /отчет/';
comment on column public.Action.Exec_user_Id is 'Изпълнител на мерка';
--comment on column public.Action.Exec_Name is 'Име изпълнител';
--comment on column public.Action.user_Id is 'Потребител';
--comment on column public.Action.BalinstSum is 'Дължима главница';
--comment on column public.Action.BalInterestSum is 'Дължима лихва';

comment on column public.Address.Address_Id is 'Адреси на задължен субект или на обект';
comment on column public.Address.AdmRegion_ID is 'Административен район';
comment on column public.Address.Municipality_Id is 'Община';
comment on column public.Address.Country_ID is 'държава';
comment on column public.Address.City_Id is 'град';
comment on column public.Address.Street_Id is 'улица';
--comment on column public.Address.Street_Name is 'Текст улица
--От номенклатура. В случаите на адрес в чужбина съдържа целия адрес, започвайки с населено място.
--Когато се адресира ЮЛ, съдържа име на улица , номер, вход, ет, ап.';
--comment on column public.Address.district is 'Квартал/ Махала';
comment on column public.Address.Nom is 'номер/подномер';
comment on column public.Address.Block is 'блок';
comment on column public.Address.Entry is 'вход';
comment on column public.Address.floor is 'етаж';
comment on column public.Address.apartment is 'апартамент';
--comment on column public.Address.postcode is 'пощенски код';
comment on column public.Address.Mailbox is 'пощенска кутия';
comment on column public.Address.Note is 'Забележка';
comment on column public.Address.Input_Code is 'Код произход:
0- Държавен регисър /ЕСГРАОН, БУЛСТАТ/
1- декларация';

comment on column public.AdmRegion.AdmRegion_ID is 'Административен район';
comment on column public.AdmRegion.City_Id is 'Населено място';
comment on column public.AdmRegion.Municipality_Id is 'Община';
comment on column public.AdmRegion.Code is 'Код на район';
comment on column public.AdmRegion.Name is 'Име на район';

comment on column public.agent.Agent_Id is 'Посредник';
comment on column public.agent.Name is 'Име на посредник/ касиер';
comment on column public.agent.Note is 'Забележка';
comment on column public.agent.IsActive is 'Активен:
0 - не
1 - да';


comment on column public.BAccount.Municipality_Id is 'Община';
comment on column public.BAccount.IsBase is 'Основна сметка /за НИ, съобщения/';
comment on column public.BAccount.IsActive is 'Активна
1 - да
0 - не';
comment on column public.BAccount.AccNo is 'Номер счетоводна сметка';


comment on column public.BalDebtInst.InstSum is 'Остатък главница';
comment on column public.BalDebtInst.InterestSum is 'остатък лихва';
comment on column public.BalOverInst.overSum is 'Надвнесена сума';


comment on column public.Bank.BIC is 'Код банка';
comment on column public.Bank.Name is 'Наименование на банката';
comment on column public.Bank.Address is 'Адрес на банката';
comment on column public.Bank.Mask_Id is 'Маска на файл - идентификатор';



comment on column public.Building.Building_id is 'Сграда';
comment on column public.Building.BuildingNo is 'Уникален номер на сграда
ген. от системата
ЕЕЕЕ B N
ЕЕЕЕ - Код община по ЕБК
B - Building
N - пореден номер от брояча';
comment on column public.Building.Property_id is 'Имот';
comment on column public.Building.SeqNoBuilding is 'Пореден номер сграда';
comment on column public.Building.KindFunction is 'Предназначение на сграда:
1 - Къща, вила, лятна кухня
2 - Жилищен блок
3 - Гараж /самостоятелна сграда/
4 - Друга второстепенна сграда
5 - Търговска
6 - Производствена
7 - Селскостопанска
8 - Друга нежилищна';
comment on column public.Building.FloorNumber is 'Брой етажи';
comment on column public.Building.FloorNumOver is 'Брой етажи над земята';
comment on column public.Building.Elevator is 'Асансьор
0 - не
1 - да';
comment on column public.Building.monument is 'Паметник на културата
0 - не
1 - да';
comment on column public.Building.MonumentDoc is 'Брой на ДВ в който сградата е обявена за паметник на културата';
comment on column public.Building.MonumentDate is 'Година в който е обявен за паметник';
comment on column public.Building.PublicTransport is 'Сградата се използва за обществен транспорт
0 - не
1 - да';
comment on column public.Building.Farm is 'Селскостопанска сграда
1 - да
0 - не';
comment on column public.Building.Damage is 'Самосрутване или вредност
0- не
1- да';
comment on column public.Building.DamageDoc is 'Докмент за самосрутване или вредност - номер';
comment on column public.Building.DamageDocDate is 'Година на документа за самосрутване или вредност';
comment on column public.Building.DamageDocPubl is 'Издал документ за самосрутване или вредност';
comment on column public.Building.IsTemporary is 'Временна сграда
0 - не
1 - да';
comment on column public.Building.ZEESertificat is 'Сертификат по закона за енергийна ефективност(ЗЕЕ)';
comment on column public.Building.BuildYear is 'Година на посрояване на сградага';
comment on column public.Building.ZEECategory is 'Категория по ЗЕЕ
Елемент от списък
А; Б по Закона за енергийната ефективност';
comment on column public.Building.ZEESertNo is 'Номер на сертификата по ЗЕЕ';
comment on column public.Building.ZEESertDate is 'Дата на сертификата по ЗЕЕ';
comment on column public.Building.ZEESertPubl is 'Издател на сертификата по ЗЕЕ';
comment on column public.Building.ZEEActivity is 'Мерки за оползотворяване на възобновяеми енергийни източници:
0 - не
1 - да';
comment on column public.Building.BCK is 'Сграда на БЧК';
comment on column public.Building.outland is 'Сграда на друга държава';
comment on column public.Building.DutyFree is 'Друго основание за освобождаване от данък';
comment on column public.Building.DutyFreeOrder is 'Разпоредба за освобождаване от данък';
comment on column public.Building.Note is 'Забележка';
comment on column public.Building.User_id is 'Код служител въвел информацията';
comment on column public.Building.UserDate is 'Дат на последна актуализация';
comment on column public.Building.ErrorData is 'Грешни данни';
comment on column public.Building.RestoreBuild is 'Сграда, възстановена по закон - Ползвател на обект с възстановена по закон собственост:
0 - не
1 - да';
comment on column public.Building.RestoreBuild_Date is 'Дата на документ за възстановяване на обекта';
comment on column public.Building.RestoreBuildDoc is 'Документ за ползване на възстановен обект:';
comment on column public.Building.RestoreYear is 'Година на възстановяване';
comment on column public.Building.Used_From is 'Ползвател на имота';


--comment on column public.CarReg.Mark_Code is 'Код марка';
--comment on column public.CarReg.Mark_name is 'Марка';
--comment on column public.CarReg.Model_Code is 'Код модел';
--comment on column public.CarReg.Model_Name is 'Наименование на модел';
comment on column public.CarReg.Seat_Number is 'Брой места';
comment on column public.CarReg.Weigth_Total is 'Общо тегло';
comment on column public.CarReg.Weigth_own is 'Собствено тегло';
comment on column public.CarReg.Motor_capacity is 'Обем на двигател';
comment on column public.CarReg.HorsePower is 'Мощност на двигател (К.с.)';
comment on column public.CarReg.door_Number is 'Брой врати';
comment on column public.CarReg.Carosserie is 'Каросерия';
comment on column public.CarReg.Tug_Code is 'Код влекач';
comment on column public.CarReg.Kind_KAT is 'Вид според КАТ';
comment on column public.CarReg.Kind is 'Вид';
comment on column public.CarReg.IsActive is 'Активен:
1 - да
0 - не';



comment on column public.CarTaxPrice.Municipality_Id is 'Община';
comment on column public.CarTaxPrice.TaxPeriod_Id is 'Данъчен период';
comment on column public.CarTaxPrice.TranspMeansReg_Id is 'Вид превозно средство от номенклатура';
comment on column public.CarTaxPrice.SeqNumber is 'Пореден номер интервал';
comment on column public.CarTaxPrice.MeasureFrom is 'Мярка от';
comment on column public.CarTaxPrice.MeasureTo is 'Мярка до';
comment on column public.CarTaxPrice.NormValueFrom is 'Нормативен размер на данъка ОТ';
comment on column public.CarTaxPrice.NormVallueTO is 'Нормативен размер на данъка ДО';
comment on column public.CarTaxPrice.PriceValue is 'Цена';
comment on column public.CarTaxPrice.MeasureUnit is 'Единица мярка 
0 - общо
1 - за единица';



comment on column public.City.City_Id is 'Населено място';
comment on column public.City.Municipality_Id is 'Община';
comment on column public.City.Kind_City is 'Вид на населено место:';
comment on column public.City.Name is 'Име на населено место';
comment on column public.City.EKATTE is 'Код по единния държавен регистър';
comment on column public.City.PostCode is 'Пощенски код';


comment on column public.Company.TaxSubject_Id is 'Задължен субект';
comment on column public.Company.EndDate is 'Дата закриване';


comment on column public.DelegateCompany.Municipality_Id is 'Община';
comment on column public.DelegateCompany.Agent_Id is 'Посредник';


comment on column public.Config.Municipality_Id is 'Община';


comment on column public.ContainerNorm.TaxPeriod_Id is 'Данъчен период';
comment on column public.ContainerNorm.City_Id is 'Населено място';
comment on column public.ContainerNorm.KindContainer is 'Вид съд за сметосъбиране:
1 - КУКА
2 - БОБЪР
3 - БУРГАС';
comment on column public.ContainerNorm.Value is 'Годишна сума за ТБО';


comment on column public.Country.Country_ID is 'Държава';
comment on column public.Country.Name is 'Пълно име на държава';
comment on column public.Country.Code is 'Код на държавата';
comment on column public.Country.shortname is 'Кратко име на държавата';
comment on column public.Country.citizenship is 'гражданство /наименование/';


comment on column public.DebtInstalment.InstNo is 'Номер на дължима вноска';
comment on column public.DebtInstalment.TermPay_Date is 'Срок на плащане';
comment on column public.DebtInstalment.InstSum is 'Начислена сума вноска по главница';
comment on column public.DebtInstalment.IntBeginDate is 'Начална дата на олихвяване';


comment on column public.DebtinstalmentCorr.Corr_Date is 'Дата на корекция';
comment on column public.DebtinstalmentCorr.InstNo is 'Номер на дължима вноска';
comment on column public.DebtinstalmentCorr.TermPay_Date_Old is 'Срок на плащане';
comment on column public.DebtinstalmentCorr.InstSum_Old is 'Начислена сума вноска по главница';
comment on column public.DebtinstalmentCorr.InterestSum_Old is 'Начислена  Сума лихва';
comment on column public.DebtinstalmentCorr.DiscSum_Old is 'Сума отстъпка';
comment on column public.DebtinstalmentCorr.user_Id is 'Потребител';
comment on column public.DebtinstalmentCorr.PayInstSum is 'Сума платена вноска от сума намаление на задължението';
comment on column public.DebtinstalmentCorr.PayInterestSum is 'Сума платена лихва от сума намаление на платена лихва';


comment on column public.DebtPartProperty.DebtPartProperty_Id is 'Разпределение на собствеността';
comment on column public.DebtPartProperty.DebtSubject_Id is 'Задължение на субекта';
comment on column public.DebtPartProperty.TaxPeriod_Id is 'Данъчен период';
comment on column public.DebtPartProperty.KindProperty is 'Вид на имота:
1 - земя
2 - сграда';
comment on column public.DebtPartProperty.IsRelief is 'Инвалидност:
0 - не
1 - да';
comment on column public.DebtPartProperty.Relief_Id is 'Данъчни облекчения';
comment on column public.DebtPartProperty.SumVal is 'Сума годишна данъчна оценка';
comment on column public.DebtPartProperty.SumTax is 'Сума годишен данък';
comment on column public.DebtPartProperty.TaxBeginDate is 'Облагане от дата';
comment on column public.DebtPartProperty.TaxEndDate is 'Облагане до дата';
comment on column public.DebtPartProperty.TotalVal is 'Данъчна оценка за период без освобождаване';
comment on column public.DebtPartProperty.TotalTax is 'Данък за период нето';
comment on column public.DebtPartProperty.HOMEOBJ_ID is 'Обект на имот';
comment on column public.DebtPartProperty.freefrom is 'Освободен от месец';
comment on column public.DebtPartProperty.freemonths is 'Брой месеци освободен от данък';
comment on column public.DebtPartProperty.CodeTBO is 'Код такса битови отпадъци';
comment on column public.DebtPartProperty.PromilTBO is 'Промили за ТБО';
comment on column public.DebtPartProperty.parentdebtprop_id is 'Корекция към задължение';
comment on column public.DebtPartProperty.freesuma_obj is 'Сума освободен - за обекта';
comment on column public.DebtPartProperty.FreeSuma_subj is 'Сума освобождаване за субекта';


comment on column public.DebtSubject.DebtSubject_Id is 'Задължение на субекта';
comment on column public.DebtSubject.Municipality_Id is 'Община';
comment on column public.DebtSubject.TaxSubject_Id is 'Данъчен субект';
comment on column public.DebtSubject.Document_Id is 'В зависимост от 
TaxDoc_Id или ct_Id илиRequest_Id';
comment on column public.DebtSubject.KindDebtReg_Id is 'Вид задължение:
/Код вид плащане /';
comment on column public.DebtSubject.PartidaNo is 'Номер партида';
comment on column public.DebtSubject.KindDoc is 'Вид документ:
1 - TaxDoc - Данъчна декларация:
2 - Act  - Акт( АУАН/Наказат.пост.
 за глоба,
 прихващане..);
3 - Request - Молби и искания
4 - Безобложни';
comment on column public.DebtSubject.DocCode is 'Код документ:
За декларации:
14,17,61...';
comment on column public.DebtSubject.TaxPeriod_Id is 'Данчен период';
--comment on column public.DebtSubject.Tax_BeginDate is 'Облагане от дата';
comment on column public.DebtSubject.Tax_EndDate is 'Облагане до дата';
comment on column public.DebtSubject.CalcDate is 'Дата облагане /изчисление на данъка/';
comment on column public.DebtSubject.PrtDate is 'Дата отпечатване на съобщение';
comment on column public.DebtSubject.Relief_Id is 'ТЕЛК';
comment on column public.DebtSubject.TotalVal is 'Cума данъчна оценка';
comment on column public.DebtSubject.TotalTax is 'Сума данък';
comment on column public.DebtSubject.FreeSum_obj is 'Сума отстъпка за имота';
comment on column public.DebtSubject.FreeSum_Subj is 'Сума освобождаване на субекта';
comment on column public.DebtSubject.CodeTBO is 'Код ТБО за имота:
1 - пълен размер; 
3 -без такса;
4- според количеството;
5- сметосъбиране и депо;
6- депо;
7-депо и чистота;
8- чистота;
9- # промил;

По подразбиране- пълен размер';
comment on column public.DebtSubject.inst_number is 'Брой вноски';
comment on column public.DebtSubject.Corr_instnumber is 'Брой коригирани вноски';
comment on column public.DebtSubject.Corr_SumTotal is 'Сума корекция спрямо последната вноска';
comment on column public.DebtSubject.PayDiscSum is 'Реализирана отстъпка при плащане';
comment on column public.DebtSubject.DocNo is 'Входящия номер на декларация';
comment on column public.DebtSubject.Doc_Date is 'Дата на входиране на декларация';



comment on column public.DebtSubjectCorr.DebtSubject_Id is 'Задължение на субекта';
comment on column public.DebtSubjectCorr.Corr_Date is 'Дата на корекция';
--comment on column public.DebtSubjectCorr.Old_IncTaxDoc_Id is 'Стара /Коригирана/ декларация';
--comment on column public.DebtSubjectCorr.New_IncDoc_Id is 'Нова/Коригираща/ декларация';
--comment on column public.DebtSubjectCorr.Corr_InstNumber is 'Брой коригиращи вноски';
comment on column public.DebtSubjectCorr.User_Date is 'Дата корекция';
comment on column public.DebtSubjectCorr.user_Id is 'Потребител коригирал задължение';




comment on column public.Decode.ColumnName is 'Наименование на колона';
comment on column public.Decode.Code is 'Код';
comment on column public.Decode.Value is 'Съкратена стойност';
comment on column public.Decode.FullName is 'Стойност';




comment on column public.department.Municipality_Id is 'Община';


comment on column public.Discount.Discount_Id is 'Отстъпка';
comment on column public.Discount.DocumentType_Id is 'Тип документ';
comment on column public.Discount.TaxPeriod_Id is 'Данъчен период';
comment on column public.Discount.TermDisc is 'Дата до която важи отстъпка';
comment on column public.Discount.Percent is 'Процент отстъпка';
comment on column public.Discount.Condition is 'Условие за отстъпка:
1 - плащане на всички вноски до TermDisc';


comment on column public.DocumentType.DocumentType_Id is 'Тип документ';
comment on column public.DocumentType.KindDoc is 'Вид документ:
1 - TaxDoc - Данъчна декларация:
2 - Act  - Акт( АУАН/Наказат.пост.
 за глоба,
 прихващане..);
3 - Request - Молби и искания
//4 - Фактура за услуга;
5 - протоколи
6 - платежни документи
7 - сч. операции
8...';
comment on column public.DocumentType.Term_Give is 'Срок на подаване - Брой дни/месеци';
comment on column public.DocumentType.TermGive_EndDate is 'Крайна дата на подаване на документ
за чл.61 и чл.19';
comment on column public.DocumentType.Term_working is 'Срок за обработка';
comment on column public.DocumentType.Dt_AccountReg_Id is 'Счетоводна сметка - дебит';
comment on column public.DocumentType.Kt_AccountReg_Id is 'Счетоводна сметка - кредит';
comment on column public.DocumentType.IsAlwAccepting is 'Приемане след крайния срок:
0 - да безуславно;
1 - съставяне на АУАН;
2 - не се приемат ( за чл. 19);';
comment on column public.DocumentType.IsInc is 'Входящ документ
0 - не
1 - да';
comment on column public.DocumentType.Interest is 'Лихва за просрочие по този тип документ:
0 - не
1 - да';
comment on column public.DocumentType.OverInterest is 'Лихва за надвнесена сума по този документ:
0 - не
1- да';
comment on column public.DocumentType.InstNumber is 'Брой вноски';



comment on column public.Dog.Dog_Id is 'Декларация за куче';
comment on column public.Dog.Breed is 'Порода';
comment on column public.Dog.Earn_Date is 'Дата на придобиване';
comment on column public.Dog.ReasonFree is 'Изреждат се номера на основания за освобождаване, разделени със запетая:
1 - Кучета на инвалиди
2 - Служебни кучета в организациите на бюджетна издържка
3 - Кучета за опитни цели
4 - Кучета на БЧК
5 - Кастрирани кучета
6 - Ловни кчета';




comment on column public.ESGRAONChange.IDN_Old is 'Старо ЕГН';
comment on column public.ESGRAONChange.IDN_New is 'Ново ЕГН';
comment on column public.ESGRAONChange.KindChange is 'Вид промяна:
1 - Даден ЕГН 
2 - Изтрит ЕГН /IDN_Old се изтрива/
3 - коригиран 
4 -  освободен /при наличие на 2 ЕГН - IDN_Old се изтрива, остава IDN_New/
5- дублиран /две лица с един ЕГН/';



comment on column public.Exchange_Reg.Exchange_Id is 'Вид валута или ценни книжа';
comment on column public.Exchange_Reg.Kind is 'Вид:
1 - Валута
2 - Ценни книжа';
comment on column public.Exchange_Reg.Code is 'Код валута';
comment on column public.Exchange_Reg.FullName is 'наименование';
comment on column public.Exchange_Reg.Name is 'Съкратено наименование';
comment on column public.Exchange_Reg.Emission is 'Издател на ценни книжа';


comment on column public.FinishCashier.user_Id is 'Kasier';
comment on column public.FinishCashier.UserName is 'Име касиер';
comment on column public.FinishCashier.DT_Sum is 'Инкасирана сума';
comment on column public.FinishCashier.KT_Sum is 'Сума върнати';


comment on column public.FinishDay.To_date is 'До дата - Пълна дата с час';
comment on column public.FinishDay.user_Id is 'Потребител приключил деня';
--comment on column public.FinishDay.UserDate is 'Системна Дата приключване';


comment on column public.FirmProperty.FirmProp_Id is 'Декл.17- Недвижими имоти';
comment on column public.FirmProperty.Property_id is 'Жилищен имот, деклариран с декларация по чл. 14';
comment on column public.FirmProperty.KindProperty is 'Вид на имота
1 - Земя
2 - Сграда(и)
3 - Земя и сграда';
comment on column public.FirmProperty.LocationProperty is 'Местонахождение на имота';
comment on column public.FirmProperty.Location_Municipality_Id is 'Община - местонахождение на имота';
comment on column public.FirmProperty.Property_Address_Id is 'Адреси на задължен субект или на обект';
comment on column public.FirmProperty.EarnWay is 'Начин на придобиване';
comment on column public.FirmProperty.PropertyDoc is 'Документ за собственост - вид, издател';
comment on column public.FirmProperty.PropertyDocNo is 'Документ за собственост -  номер';
comment on column public.FirmProperty.PropertyDoc_Date is 'Документ за собственост - дата';
comment on column public.FirmProperty.Old_TaxSubject_Id is 'Предишния собственик';
comment on column public.FirmProperty.OldPropertyNote is 'Други данни за предишния собственник';
comment on column public.FirmProperty.KadastrNo is 'Кадастрален номер';
comment on column public.FirmProperty.Kadastr_Year is 'Година на одобряване на кадастр.план';
comment on column public.FirmProperty.ZRPNo_District is 'Номер по ЗРП - квартал';
comment on column public.FirmProperty.ZRPNo_Parcel is 'Номер по ЗРП - парцел';
comment on column public.FirmProperty.ZRP_Date is 'Година на одобряване на ЗРП';
comment on column public.FirmProperty.Note is 'Други данни';
comment on column public.FirmProperty.Status is 'Статус на декларация за имот:
0 : активна партида;
1- разлики декларирани - изчислени стойности, 
9- закрита партида';
comment on column public.FirmProperty.Repl_User_Name is 'Длъжностно лице дало служебната информация';
comment on column public.FirmProperty.ErrorData is 'Грешки при съставяне на документа';
--comment on column public.FirmProperty.PropertyNo is 'Уникален номер на жилищен имот';
comment on column public.FirmProperty.TaxProperty is 'Данъчна оценка на жилищен имот';
comment on column public.FirmProperty.IsFalse_TaxProperty is 'Грешни данни за жилищни имоти:
0 - не
1 - да';
comment on column public.FirmProperty.TaxProp_Decl is 'Деклариран данък за недвижими имоти';
comment on column public.FirmProperty.TaxProp_Calc is 'Изчислен  данък за недвижими имоти';
comment on column public.FirmProperty.IsFalse_TaxProp is 'Разлика между данни за данък недв.имоти - изчислен и деклариран:
0 - не
1- да';
comment on column public.FirmProperty.TaxGarb_Decl is 'ТБО - декларирана';
comment on column public.FirmProperty.TaxGarb_Calc is 'ТБО - изчислена';
comment on column public.FirmProperty.IsFalse_TaxGarb is 'Разлика между данни за ТБО недв.имоти - изчислена и декларирана:
0 - не
1- да';
comment on column public.FirmProperty.TaxDate_OldProp is 'Месец и година, до която е платен данък недв. имоти от предишния собственик';
comment on column public.FirmProperty.CodeTBO is 'Код ТБО за имота: 
3-без такса;
5- сметосъбиране и депо;
6- депо;
7-депо и чистота;
8- чистота;
9- различен  промил;';
comment on column public.FirmProperty.Promilly is 'Стойност на промил / ако е различен/';
comment on column public.FirmProperty.user_Id is 'Потребител';
comment on column public.FirmProperty.User_Date is 'Дата на последна корекция';
comment on column public.FirmProperty.IsHome is 'Жилищен имот:
0 - не
1 - да';
comment on column public.FirmProperty.Owner_TaxSubject_Id is 'Собственик на имота ако декларатора е ползвател или концесионер';



comment on column public.FirmPropObj.FirmPropObj_Id is 'Недвижим обект';
--comment on column public.FirmPropObj.FirmProp_Id is 'Декл.17- Недвижими имоти';
comment on column public.FirmPropObj.SeqNo is 'Пореден номер на имота';
comment on column public.FirmPropObj.BuildDate is 'Година на построяване';
comment on column public.FirmPropObj.TypeProp is 'Вид на имота/обекта/земя/сграда';
comment on column public.FirmPropObj.KindOwner is 'Вид на собственост:
1 - частна
2 - общинска
3 - државна';
comment on column public.FirmPropObj.Earn_Date is 'Дата на придобиване /учредяване на ПП/';
comment on column public.FirmPropObj.CircumChange_Date is 'Дата на промяна на обстоятелство';
comment on column public.FirmPropObj.Function is 'Предназначение на обекта
/ текст/';
comment on column public.FirmPropObj.TaxFreeReason is 'Основание за освобождаване от данък:
8.1 -  Имотът е публична общинска собственост, който не се използва със стопанска цел, несвързана с пряката му дейност;
8.2 - - 8.15 
изреждат се точки, отделени със запетая';
comment on column public.FirmPropObj.isBusiness is 'Стопанска цел:
0 - не
1 - да';
comment on column public.FirmPropObj.AccValue is 'Отчетна стойност';
comment on column public.FirmPropObj.EarnTaxValue_Decl is 'Данък за годината на придобиване/промяна - деклариран';
comment on column public.FirmPropObj.EarnTaxValue_Calc is 'Данък за годината на придобиване/промяна - изчислен';
comment on column public.FirmPropObj.IsFalse_EarnTaxValue is 'Разлика между данни за Данък за годината на придобиване/промяна - изчислен и деклариран:
0 - не
1- да';
comment on column public.FirmPropObj.TaxValue_Decl is 'Годишен данък - деклариран';
comment on column public.FirmPropObj.TaxValue_Calc is 'Годишен данък - изчислен';
comment on column public.FirmPropObj.IsFalse_TaxValue is 'Разлика между данни за Годишен данък - изчислен и деклариран:
0 - не
1- да';
comment on column public.FirmPropObj.IsPublic is '???Публична собственост:
0 - не
1 - да';
comment on column public.FirmPropObj.IsMunicip is '???Общинска собственост с наематели/Ползватели:
0 - не
1 - да';
comment on column public.FirmPropObj.IsTaxFree is 'Държавна публична собственост, предоставена за ползване на друго лице и то не е освободено от данък:
0 - не / има данък/
1 - да / няма данък/';
comment on column public.FirmPropObj.DamageDocDate is 'Дата на документ за самосрутване';
comment on column public.FirmPropObj.MonumentDoc is 'Брой на ДВ в който сградата е обявена за паметник на културата';
comment on column public.FirmPropObj.MonumentDate is 'Година в който е обявен за паметник';
comment on column public.FirmPropObj.IsZee is 'Наличие на сертификат по ЗЕЕ:
0 - не
1 - да';
comment on column public.FirmPropObj.ZEECategory is 'Категория по ЗЕЕ:
А
Б';
comment on column public.FirmPropObj.ZEESertNo is 'Номер на сертификата по ЗЕЕ';
comment on column public.FirmPropObj.ZEESertDate is 'Дата на сертификата по ЗЕЕ';
comment on column public.FirmPropObj.ZEESertPubl is 'Издател на сертификата по ЗЕЕ';
comment on column public.FirmPropObj.ZEESrcEnergy is 'Възобновяем енергиен източникпо ЗЕЕ';



comment on column public.FromAddress.Flag is 'Флаг:
0 - жилищен адрес
1 - административна сграда
2 - жилищен адрес и едминистративна сграда
3 - сграда и строеж
4 - разрушена сграда
5 - празно дврно място
6 - дом Майка и дете
7 - дом Стари хора';
comment on column public.FromAddress.Status is 'Код на състояние:
0 - съществуващ адрес
4 - закрит адрес';
comment on column public.FromAddressOrg.IDN is 'ЕИК';
comment on column public.FromAddressOrg.KindAddress is 'Вид на адреса:
Седалище
кореспонденция
местоизвършване';
comment on column public.FromAddressOrg.Country is 'Държава';
comment on column public.FromAddressOrg.CityNo is 'ЕККАТЕ';
comment on column public.FromAddressOrg.Street is 'Код на улица';
comment on column public.FromAddressOrg.Rayon is 'Район';
comment on column public.FromAddressOrg.PostCode is 'Пощенски код';
comment on column public.FromAddressOrg.PostMail is 'Пощенска кутия';
comment on column public.FromAddressOrg.Address is 'Адрес( населено място, ж.к., кв., ул., бул., пл., №, вх., ет., ап.)';
comment on column public.FromAddressOrg.Corr_Date is 'Дата на вписване на актуализацията';


comment on column public.FromBulstat.IDN is 'ЕИК';
comment on column public.FromBulstat.StatusSubject is 'Юридически статус на субекта';
comment on column public.FromBulstat.GroupSubject is 'Група на субект';
comment on column public.FromBulstat.KindSubject is 'Вид на субекта';
comment on column public.FromBulstat.FullName is 'Пълно наименование/търговска фирма';
comment on column public.FromBulstat.KindGroup is 'Вид обединение на търговци';
comment on column public.FromBulstat.TermExists is 'Срок на съществуване - в месеци';
comment on column public.FromBulstat.LevelSubject is 'Ниво на подчиненост на субекта';
comment on column public.FromBulstat.Realization is 'Реализация на нефизическото лице';
comment on column public.FromBulstat.End_Date is 'Дата на прекратяване';
comment on column public.FromBulstat.Corr_Date is 'Дата на вписване на актуализацията';


comment on column public.FROMCharSubject.IDN is 'ЕИК';


comment on column public.FromESGRAON.Age is 'век:
0 - 18ХХ
1 - 19ХХ
2 - 20ХХ';
comment on column public.FromESGRAON.IDN is 'Идентификационен номер - ЕГН/ЛНЧ';
comment on column public.FromESGRAON.firstname is 'собствено име';
comment on column public.FromESGRAON.sirname is 'бащино име';
comment on column public.FromESGRAON.family_name is 'фамилно име';
comment on column public.FromESGRAON.Citizenship1 is 'Гражданство1';
comment on column public.FromESGRAON.Citizenship2 is 'Гражданство2';
comment on column public.FromESGRAON.IdentDoc_Kind is 'Вид документ за самоличност:
0 - личен паспорт
1 - удост. на самоличност на чужденец
2 - лична карта на БГ гражданин
3 - карта на пост. пребиваващ чужденец
4 - карта на бежанец';
comment on column public.FromESGRAON.IdentDocNo is 'Лична карта номер';
comment on column public.FromESGRAON.Emission_Date is 'Дата на издаване на документа';
comment on column public.FromESGRAON.IdentDoc_RDVRNo is 'Лична картаИздател - РДВР';
comment on column public.FromESGRAON.PA_CityNo is 'Постоянен адрес - населено място';
comment on column public.FromESGRAON.PA_Street is 'Постоянен адрес -  Улица';
comment on column public.FromESGRAON.PA_Number is 'Постоянен адрес - номер и подномер';
comment on column public.FromESGRAON.PA_Entry is 'Постоянен адрес - вход';
comment on column public.FromESGRAON.PA_Floor is 'Постоянен адрес - етаж';
comment on column public.FromESGRAON.PA_Apartment is 'Постоянен адрес - апартамент';
comment on column public.FromESGRAON.PA_Date is 'Постоянен адрес - дата';
comment on column public.FromESGRAON.PA_Kind is 'Наличие на постоянен адрес:
0 - не
1 - да';
comment on column public.FromESGRAON.CityNo is 'Настоящ адрес - населено място';
comment on column public.FromESGRAON.Street is 'Настоящ адрес - улица';
comment on column public.FromESGRAON.AddrNo is 'Настоящ адрес номер и подномер';
comment on column public.FromESGRAON.Entry is 'Настоящ адрес - вход';
comment on column public.FromESGRAON.Floor is 'Настоящ адрес - етаж';
comment on column public.FromESGRAON.Apartment is 'Настоящ адрес - апартамент';
comment on column public.FromESGRAON.A_Date is 'Настоящ адрес - дата';
comment on column public.FromESGRAON.Family_Status is 'Семейно положение
1 - неженен
2 - женен
3 - вдовец
4 - разведен
9 - неизвестно';
comment on column public.FromESGRAON.IDN_father is 'ЕГН - баща';
comment on column public.FromESGRAON.indicator_IDN_father is 'Indikator непопълнено ЕГН:
1 - по неизвестна причина
2 - починал без ЕГН
3 - чужденец
4 - неизвестен';
comment on column public.FromESGRAON.IDN_mother is 'ЕГН - майка';
comment on column public.FromESGRAON.indicator_IDN_mother is 'Indikator непопълнено ЕГН:
1 - по неизвестна причина
2 - починала без ЕГН
3 - чужденка
4 - неизвестна';
comment on column public.FromESGRAON.IDN_spouse is 'ЕГН - съпруг(а)';
comment on column public.FromESGRAON.indicator_IDN_spouse is 'Indikator непопълнено ЕГН:
1 - по неизвестна причина
2 - починал/а без ЕГН
3 - чужденец/ка';
comment on column public.FromESGRAON.Dead is 'Починал:
0 - не
1 - да';
comment on column public.FromESGRAON.Dead_Date is 'Дата починал';
comment on column public.FromESGRAON.Dead_ActNo is 'Номер смъртен акт';
comment on column public.FromESGRAON.Dead_CityNo is 'населено място на акта за смърт';
comment on column public.FromESGRAON.Note is 'Забележка';
comment on column public.FromESGRAON.UserDate is 'Последна дата на актуализация';



comment on column public.GarbProperty.Property_id is 'Имот';
comment on column public.GarbProperty.TaxPeriod_Id is 'Данъчен период';


comment on column public.GarbTax.GarbTax_Id is 'Декл. зона такса битови отпадъци';
comment on column public.GarbTax.TaxPeriod_Id is 'Данъчен период';
comment on column public.GarbTax.Container_Number is 'Брой съдове за битови отпадъци';
comment on column public.GarbTax.TypeContainer is 'Вид съдове за битови отпадъци';
comment on column public.GarbTax.SW_Missing is 'Липсва сметосъбирани и сметоизвозване:
0 - не
1 - да';
comment on column public.GarbTax.Clean_Missing is 'Липсва поддържане чистота:
0 - не
1 - да';
comment on column public.GarbTax.Depot_Missing is 'Липсва обезвреждане и депо:
0 - не
1 - да';



comment on column public.GetProperty.GetProperty_Id is 'Декларация по чл.49';
comment on column public.GetProperty.IsExchange is 'Чуждестранна валута:
0 - не
1 - да';
comment on column public.GetProperty.Exchange_Id is 'Вид валута';
comment on column public.GetProperty.IsPaper is 'Ценни книжа:
0 - не
1 - да';
comment on column public.GetProperty.Paper_Exchange_Id is 'Ценни книжа';
comment on column public.GetProperty.Paper_Number is 'Брой ценни книжа';
comment on column public.GetProperty.Paper_Value is 'Стойност ценни книжа';
comment on column public.GetProperty.Paper_Emission is 'Издадени от';
comment on column public.GetProperty.IsOtherProperty is 'Друго имущество:
0 - не
1 - да';
comment on column public.GetProperty.OtherProperty is 'Друго имущество, а именно вид';
comment on column public.GetProperty.OtherProperty_Number is 'Друго имущество - брой';
comment on column public.GetProperty.OtherProperty_Value is 'Друго имущество стойност';
comment on column public.GetProperty.IsCondone is 'Опрощаване:
0 - не
1 - да';
comment on column public.GetProperty.Condone_Value is 'Опрощаване на стойност';
comment on column public.GetProperty.Note is 'Други данни';
comment on column public.GetProperty.Note_Value is 'Други данни стойност';
comment on column public.GetProperty.ContrKins is 'Страна по договора е:
1 - брат/сестра/племенник;
2 - друго лице';
comment on column public.GetProperty.IsFull is 'Данъкът се плаща изцяло от ДС:
0 - не
1 - да';
comment on column public.GetProperty.user_Id is 'Потребител';


comment on column public.Groups.Municipality_Id is 'Община';


comment on column public.GroupTBO.City_Id is 'Населено място';


comment on column public.HomeObj.HomeObj_id is 'Жилищни обекти';
comment on column public.HomeObj.HomeObjNo is 'Уникален номер на обект
ген. от системата
ЕЕЕЕ H N
ЕЕЕЕ - Код община по ЕБК
H - HomeObj
N - пореден номер от брояча';
comment on column public.HomeObj.Building_id is 'Сграда';
comment on column public.HomeObj.Function is 'Предназначение на обекта
/ текст/';
comment on column public.HomeObj.SeqNoObj is 'Пореден номер обект';
comment on column public.HomeObj.KindHomeObjReg_Id is 'Вид обект /NVIDOB/';
comment on column public.HomeObj.Earn_Date is 'Дата на придобиване';
comment on column public.HomeObj.BuildDate is 'Година на построяване';
comment on column public.HomeObj.ObjectArea is 'Разгъната застроена площ(РЗП) на обекта';
comment on column public.HomeObj.CellerArea is 'РЗП на мазе в кв.м.';
comment on column public.HomeObj.AtticArea is 'РЗП на таван в кв.м.';
comment on column public.HomeObj.TotalArea is 'Общо РЗП';
comment on column public.HomeObj.Floor is 'Етаж';
comment on column public.HomeObj.isBusiness is 'Стопанска цел:
0 - не
1 - да';
comment on column public.HomeObj.Height is 'Височина';
comment on column public.HomeObj.KindConstruction is 'Вид на конструкция /NVKON/ :
ПН - паянтова;
ПМ - полумасивна
М1 - масивна без ..
М2 - панелна
М3 - масивни монолитни';
comment on column public.HomeObj.isElectro is 'Електрифициран:
0 - не
1 - да';
comment on column public.HomeObj.isWater is 'Водопровод:
0 - не
1 - да';
comment on column public.HomeObj.isSewer is 'Канализация:
0 - не
1 - да';
comment on column public.HomeObj.isTEC is 'Топлофициран:
0 - не
1 - да';
comment on column public.HomeObj.isTelefon is 'Телефон:
0 - не
1 - да';
comment on column public.HomeObj.RepairDate is 'Година на основен ремонт';
comment on column public.HomeObj.isHeating is 'Отоплителна инсталация:
0 - не
1 - да';
comment on column public.HomeObj.isAircondition is 'Климатична инсталация:
0 - не
1 - да';
comment on column public.HomeObj.LuxWindow is 'Луксозна дограма:
0 - не
1 - да';
comment on column public.HomeObj.SoundInsulation is 'Звукова или топлинна изолация:
0 - не
1 - да';
comment on column public.HomeObj.SpecialRoof is 'Специално покривно покритие:
0 - не
1 - да';
comment on column public.HomeObj.LuxDecorate is 'Луксозни декоративни елементи и облицовки:
0 - не
1 - да';
comment on column public.HomeObj.NoUseDoc is 'Документ, че обекта не може да се ползва';
comment on column public.HomeObj.NoUseDate is 'Година на документа за неизползваемост на обекта';
comment on column public.HomeObj.RestoreObj is 'Сграда, възстановена по закон - Ползвател на обект с възстановена по закон собственост:
0 - не
1 - да';
comment on column public.HomeObj.RestoreObjDate is 'Дата на документ за възстановяване на обекта';
comment on column public.HomeObj.RestoreObjDoc is 'Документ за ползване на възстановен обект:
Номер/ дата/издаден от';
comment on column public.HomeObj.ZEESertificat is 'Наличие на сертификат по закона за енергийна ефективност:
категория/номер док./дата/идаден от';
comment on column public.HomeObj.User_id is 'код служител въвел информацията';
comment on column public.HomeObj.User_Date is 'Дата на последна актуализация';
comment on column public.HomeObj.ErrorData is 'Грешни данни в записа';


comment on column public.Inheritance.Inheritance_Id is 'Данък върху наследство';
comment on column public.Inheritance.InheritCertif_Municipality_Id is 'Община, издала удостоверение за наследници';
comment on column public.Inheritance.user_Id is 'Потребител';


comment on column public.InterestDebt.Debtinstalment_Id is 'Задължение';
comment on column public.InterestDebt.IntDebtSum is 'Сума лихва върху вземания:
+ - начислена
- - сторнирана';
comment on column public.InterestDebt.ToDate is 'Дата, до която е начислена лихва';


comment on column public.InterestOper.Oper_Date is 'Дата операция /плащане, прихващане/';
comment on column public.InterestOper.KindOper is 'Вид операция:
1 - начално салдо
10 - начисление
20 - сторно на лихва';
comment on column public.InterestOper.InstSum is 'Сума главница';
comment on column public.InterestOper.IntPCT is 'Лихвен процент с надбаавка';
comment on column public.InterestOper.InterestSum is 'Сума лихва със  знак:
+ начислена
- сторнирана';
comment on column public.InterestOper.user_Id is 'Потребител';



comment on column public.InterestOverInst.Oper_Date is 'Дата операция /плащане, прихващане/';
comment on column public.InterestOverInst.KindOper is 'Вид операция:
10 - начисление
20 - Сторно но лихва';
comment on column public.InterestOverInst.OverInstSum is 'Сума главница';
comment on column public.InterestOverInst.IntPCT is 'Лихвен процент с надбаавка';
--comment on column public.InterestOverInst.InterestOverSum is 'Сума лихва със  знак: + начислена- сторнирана';
comment on column public.InterestOverInst.user_Id is 'Потребител';



comment on column public.InterestPCT.Begin_Date is 'От дата';
comment on column public.InterestPCT.InterestPct is 'Лихвен процент';
comment on column public.InterestPCT.InterestPCTAdd is 'Процент/Пункт/ надбавка';
comment on column public.InterestPCT.user_Id is 'Потребител';


comment on column public.Invoice.TaxSubject_Id is 'Задължен субект';
comment on column public.InvoiceItem.ServicePrice_Id is 'Ценоразпис на услугите';
comment on column public.InvoiceItem.Municipality_Id is 'Община';


comment on column public.KindDebtReg.KindDebtReg_Id is 'Код вид задължение';
comment on column public.KindDebtReg.Code is 'Код вид плащане:';
comment on column public.KindDebtReg.Acc is 'Код за сметка 7311';
comment on column public.KindDebtReg.FullName is 'Пълно наименование на задължение';
comment on column public.KindDebtReg.Name is 'Кратко наименование на задължение
Декларации по видове
ТБО
Акт
Глоба-фиш
услуга';
comment on column public.KindDebtReg.IsActive is 'активност:
0 - не
1 - да';


comment on column public.KindHomeObjReg.Code is 'Код';
comment on column public.KindHomeObjReg.FullName is 'Наименование';
comment on column public.KindHomeObjReg.Name is 'Съкратено наименование';

comment on column public.KindParReg.ParReg_Code is 'Код на подпараграф';
comment on column public.KindParReg.ParReg_Name is 'Наименование на подпараграф';


comment on column public.Land.Land_id is 'Земя';
comment on column public.Land.LandNo is 'Уникален номер на земя
ген. от системата
ЕЕЕЕ L N
ЕЕЕЕ - Код община по ЕБК
L - Land
N - пореден номер от брояча';
comment on column public.Land.Property_id is 'Имот';
comment on column public.Land.TypeDeclar is 'Тип декларатор  - собственик/Ползвател:
1 - Собственик на земята
2 - Ползвател на земята';
comment on column public.Land.BuildingOwner is 'Собственик на сграда върху общински терен:
0 - не
1 - да';
comment on column public.Land.LandArea is 'Площ на земята в кв. м.';
comment on column public.Land.BuiltUpArea is 'Застроена площ в кв.м.';
comment on column public.Land.IsFence is 'Наличие на масивна ограда:
0 -  не
1 -  да';
comment on column public.Land.FenceHeight is 'Височина на масивна ограда';
comment on column public.Land.FenceLength is 'Дължина на масивна ограда в м.';
comment on column public.Land.IsCovering is 'Наличие на трайна настилка:
0 -  не
1 -  да';
comment on column public.Land.CoveringArea is 'Площ на трайна настилка в кв. м.';
comment on column public.Land.IsSportCovering is 'Наличие на спортна площадка с трайна настилка:
0 -  не
1 -  да';
comment on column public.Land.SportArea is 'Площ на спортна площадка с трайна настилка в кв.м.';
comment on column public.Land.IsPool is 'Наличие на басейн:
0 -  не
1 -  да';
comment on column public.Land.PoolCapacity is 'Обем на басейн  в куб.м.';
comment on column public.Land.IsGreenParking is 'Наличие на аркинг за обществено ползване зелени:
0 -  не
1 -  да';
comment on column public.Land.GreenParking is 'Площ на паркинг за обществено ползване зелени в кв.м.';
comment on column public.Land.IsParking is 'Наличие на всички останали паркинги:
0 -  не
1 -  да';
comment on column public.Land.ParkingArea is 'Площ на всички останали паркинги в кв.м.';
comment on column public.Land.IsPark is 'Парк за общ. ползване
1 - да
2 - не';
comment on column public.Land.IsSport is 'Имота е спортно игрище
0 - не
1 - да';
comment on column public.Land.IsPublic is 'имот за други обществени нужди
0 - не
1 - да';
comment on column public.Land.KindPublicProperty is 'Вид на имот за обществени нужди';
comment on column public.Land.DutyFree is 'Друго основание за освобождаване
0 - не
1 - да';
comment on column public.Land.DutyFreeOrder is 'Разпоредба за освобождаване от данък';
comment on column public.Land.IsBusiness is 'Имота се ползва със стопанска цел
0 - не
1 - да';
comment on column public.Land.RestoreLand is 'Ползвател на земя с възстановена по закон собственост
0 - не
1 - да';
comment on column public.Land.RestoreLandDoc is 'Документ за ползване на възстановена земя';
comment on column public.Land.RestoreLandDate is 'Дата на възстановяване на земята';
comment on column public.Land.User_id is 'Служител въвел информацията';
comment on column public.Land.User_Date is 'Дата последна корекция';
comment on column public.Land.ErrorData is 'Грешни данни в записа';
comment on column public.Land.Used_From is 'ползвателя на земята и доказателство, ако земята се ползва';



comment on column public.Mask.KindMask is 'Вид маска:
1- НИ
2 - ПН';


comment on column public.Message.TaxSubject_Id is 'До кого е пратено съобщение';
comment on column public.Message.Message_Date is 'Дата съобщение';
comment on column public.Message.Message_Code is 'Код на съобщение';
--comment on column public.Message.Message_Note is 'Забележка';
comment on column public.Message.Deliver_Date is 'Дата връчване';
comment on column public.Message.Deliver_Note is 'Забележка';
comment on column public.Message.Message_user_Id is 'съставил съобщението';
comment on column public.Message.Wait_Date is 'Крайна дата на изчакване на декларатора при изпратено съобщение за явяване';
--comment on column public.Message.Message_Finish is 'Код приключено';


comment on column public.Municipality.Municipality_Id is 'Община';
--comment on column public.Municipality.Address_Id is 'Адреси на задължен субект или на обект';
comment on column public.Municipality.Province_Id is 'Област';
comment on column public.Municipality.Name is 'Име на община';
comment on column public.Municipality.Code is 'Код  на община и административен район
ООООРР';
comment on column public.Municipality.EBK_Code is 'Код на общината по Единна бюджетна класификация';


comment on column public.NormBS.normYear is 'Нормативи за година';
comment on column public.NormBS.KindConstruction is 'Вид конструкция';
comment on column public.NormBS.ApartmentValue is 'Стойност апартамент - 1 кв.м.';
comment on column public.NormBS.NoHouseValue is 'Нежилищна сграда - 1 кв.м.';
comment on column public.NormBS.PctWornOut is 'Годишен процент овехтяване';
comment on column public.NormBS.WornOutLimit is 'Граница на коефициент овехтяване';


comment on column public.NormBSObject.NormYear is 'Нормативи за година';
comment on column public.NormBSObject.KindPurpose is 'Код предназначение на сграда';
comment on column public.NormBSObject.KindObject is 'Код вид обект';
comment on column public.NormBSObject.PurposeName is 'Наименование на предназначение';
comment on column public.NormBSObject.ObjectName is 'Наименование вид обект';
comment on column public.NormBSObject.NormValue is 'Поле в масив NormBS_T2T9
1 - къща
2 - апартамент
3 - нежилищна сграда';
comment on column public.NormBSObject.pctValue is '% от стойността';


comment on column public.NormET.NormYear is 'Нормативи за година';
comment on column public.NormET.Floor is 'Етаж';
comment on column public.NormET.NoElevatorNoHome is 'сграда без асансьор с повече от 5 етажа - нежилищна';
comment on column public.NormET.NoElevatorApartment is 'сграда без асансьор с повече от 5 етажа - апартамент';
comment on column public.NormET.NoHouse is 'За всички останали нежилищни сгради';
comment on column public.NormET.Apartment is 'За всички останали апартаменти';


comment on column public.NormKi.normYear is 'Нормативи за година';
comment on column public.NormKi.KindElement is 'Вид елемент';
comment on column public.NormKi.HaveValue is 'Стойност при има';
comment on column public.NormKi.HaventValue is 'Стойност при няма';
comment on column public.NormKi.HaveRegionValue is 'Стойност няма в сграда, но има в район';


comment on column public.NormKM3.normYear is 'Нормативи за година';
comment on column public.NormKM3.Category_City is 'Категория населено место';
comment on column public.NormKM3.Groupe is 'Група - при 0 - код нас. место
при 1 - 1 или 2
иначе 0';
comment on column public.NormKM3.KZone1 is 'Коефициент зона 1';
comment on column public.NormKM3.KZone2 is 'Коефициент зона 2';
comment on column public.NormKM3.KZone3 is 'Коефициент зона 3';
comment on column public.NormKM3.Kzone4 is 'Коефициент зона 4';
comment on column public.NormKM3.KZone5 is 'Коефициент зона 5';
comment on column public.NormKM3.InBound is 'Коефициент в строителни граници';
comment on column public.NormKM3.OutBound is 'Коефициент извън строителни граници';
comment on column public.NormKM3.VillaZone1 is 'Коефициент вилна зона 1';
comment on column public.NormKM3.VillaZone2 is 'Коефициент вилна зона 2';


comment on column public.NormKM4.NormYear is 'Нормативи за година';
comment on column public.NormKM4.Category_City is 'Категория населено место';
comment on column public.NormKM4.Groupe is 'Група';
comment on column public.NormKM4.ProductionBuildingBM is 'Производствени сгради - Благоприятно местоположение';
comment on column public.NormKM4.ProductionBuildingNBM is 'Производствени сгради - неблагоприятно местоположение';
comment on column public.NormKM4.FarmBuildingBM is 'Селскостопански сгради - Благоприятно местоположение';
comment on column public.NormKM4.FarmBuildingNBM is 'Селскостопански сгради - Неблагоприятно местоположение';

comment on column public.NormPOD.NormYear is 'Нормативи за година';
comment on column public.NormPOD.Kindchange is 'Вид подобрение
1 - отоплителна инсталация
2 - климатична инсталация
3 - Луксозна дограма
4 - Шумо и топло изолация
5 - Покривни покрития
6 - Декоративни елементи';
comment on column public.NormPOD.Have is 'Стойност при има';
comment on column public.NormPOD.Havenot is 'Стойност при НЯМА';


comment on column public.NormZZBS.normYear is 'Нормативи за година';
comment on column public.NormZZBS.KindUsing is 'Начин на ползване
1 - Трайни насаждения
2 - ниви
3 - ливади
4 - пасища';
comment on column public.NormZZBS.Category1 is '1 ва категория земеделска земя - 1 кв. м.';
comment on column public.NormZZBS.Category2 is '2 ра категория земеделска земя - 1 кв. м.';
comment on column public.NormZZBS.Category3 is '3 та категория земеделска земя - 1 кв. м.';
comment on column public.NormZZBS.Category4 is '4 та категория земеделска земя - 1 кв. м.';
comment on column public.NormZZBS.Category5 is '5 та категория земеделска земя - 1 кв. м.';
comment on column public.NormZZBS.Category6 is '6 та категория земеделска земя - 1 кв. м.';
comment on column public.NormZZBS.Category7 is '7 ма категория земеделска земя - 1 кв. м.';
comment on column public.NormZZBS.Category8 is '8 ма категория земеделска земя - 1 кв. м.';
comment on column public.NormZZBS.Category9 is '9 та категория земеделска земя - 1 кв. м.';
comment on column public.NormZZBS.Category10 is '10 та категория земеделска земя - 1 кв. м.';


comment on column public.Office.FullName is 'Наименование на салона/офиса';
comment on column public.Office.Address is 'Адрес';
comment on column public.Office.OfficeCode is 'Код на касов салон:
1 - Салон на община
2 - Аутсорс обслужване';
comment on column public.Office.Note is 'Забележка';


comment on column public.Operation.Municipality_Id is 'Община';
comment on column public.Operation.Oper_Date is 'Дата на операция';
comment on column public.Operation.OperDocNo is 'Номер на операция- уникален, генерира се от системата
/номер служебна (операционна) бележка';
comment on column public.Operation.OperCode is 'Код операция:
15 - корекция на задължение
16 - сторно платена лихва
17 - сторно касова плащане /ПК,РКО/след ежедневно прикл.
22 - прихващане';
comment on column public.Operation.OperSum is 'Сума операция без знак';
--comment on column public.Operation.Note is 'Забележка';
comment on column public.Operation.user_Id is 'Потребител';
comment on column public.Operation.Null_user_Id is 'Потребител';
comment on column public.Operation.Null_Reason is 'Основание за сторниране';
comment on column public.Operation.BalOverSum is 'Салдо надвзета преди прихващане';
comment on column public.Operation.Resolution_Id is 'Решение';
comment on column public.Operation.Cancel_PayDocument_Id is 'Сторниран Платежен документ - след ежедневно';


comment on column public.OperDebt.KindDebtReg_Id is 'Код вид задължение';
comment on column public.OperDebt.OperOverSum is 'усвоена/постъпила главница';
comment on column public.OperDebt.OperIntSum is 'усвоена/постъпила лихва';
comment on column public.OperDebt.DiscSum is 'сума  отстъпка';



comment on column public.Organization.Name is 'Наименование на фирма/оргнизация';
comment on column public.Organization.IDN is 'Идентификационен номер-
Единен идентификационен код / Булстат';
comment on column public.Organization.Kind_IDN is 'Вид идинтификатор:
20 - ЕИК
21 - БУЛСТАТ';
comment on column public.Organization.Juridical_statute is 'Юридически статут на обекта';
comment on column public.Organization.Group_Subject is 'Група на нефизическото лице/група субект';
comment on column public.Organization.Kind_Subject is 'Вид на нефизическо лице/вид търговец/';
comment on column public.Organization.Kind_Group is 'Вид обединение на търговци';
comment on column public.Organization.existence_period is 'Срок на съществуване [месец]';
comment on column public.Organization.subordinate_level is 'Ниво на подчиненост на субекта';
comment on column public.Organization.realization is 'Реализация на нефизическото лице';
comment on column public.Organization.End_Date is 'Дата на прекратяване';
comment on column public.Organization.Begin_Date is 'Дата на вписване на актуализацията';
comment on column public.Organization.Input_Code is 'Код произход:
0 - Държавен регисър /БУЛСТАТ/
1 - Декларация';


comment on column public.OverSubject.Municipality_Id is 'Община';
comment on column public.OverSubject.TaxSubject_Id is 'Задължен субект';
comment on column public.OverSubject.DebtSubject_Id is 'Задължение на субекта';
comment on column public.OverSubject.KindDebtReg_Id is 'Код вид задължение';
comment on column public.OverSubject.PartidaNo is 'Номер партида';
comment on column public.OverSubject.OverPaySum is 'Надвзето от плащания';
comment on column public.OverSubject.OverInterestSum is 'Надвзето от лихви';
comment on column public.OverSubject.OverCorSum is 'Надвзети от корекции';

comment on column public.PartGetProperty.PartGetProperty_Id is 'Собственици на придобито имущество';
comment on column public.PartGetProperty.GetProperty_Id is 'Декларация по чл.49';
comment on column public.PartGetProperty.TaxSubject_Id is 'Задължен субект';
comment on column public.PartGetProperty.SeqNoTS is 'Пор.номер собственик';
comment on column public.PartGetProperty.Part is 'Част в %';


comment on column public.PartHomeObj.SeqNoTS is 'Пор.номер собственик/ползвтел';
comment on column public.PartHomeObj.HomeObj_id is 'Жилищни обекти';
comment on column public.PartHomeObj.TaxSubject_Id is 'Задължен субект';
comment on column public.PartHomeObj.TypeDeclar is 'Вид дан субект:
1 - собственик
2 - ползвател';
comment on column public.PartHomeObj.isBaseHome is 'Основно жилище:
0 - не
1 - да';
comment on column public.PartHomeObj.Divident is 'Делимо';
comment on column public.PartHomeObj.Divisor is 'Делител';


comment on column public.parthomeusers.userPartHome_Id is 'Ползвател';
comment on column public.parthomeusers.ownerPartHome_Id is 'Собственик';
comment on column public.parthomeusers.divident is 'Делимо';
comment on column public.parthomeusers.divisor is 'Делител';
comment on column public.parthomeusers.part is 'Част';


comment on column public.PartInheritance.PartInheritance_Id is 'Наследници/ Заветници';
comment on column public.PartInheritance.Tabinheritance_Id is 'Имущества и задължения /таблици/';
comment on column public.PartInheritance.TaxSubject_Id is 'Задължен субект';
comment on column public.PartInheritance.Inheritance_Id is 'Данък върху наследство';
comment on column public.PartInheritance.KindInherit is 'Вид:
1 - наследник
2 - заветник';
comment on column public.PartInheritance.Relation is 'Родство с наследодателя:
1 - син/дъщеря
2 - брат/сестра';
comment on column public.PartInheritance.Part is 'Наследствения дял';


comment on column public.PartLand.TaxSubject_Id is 'Задължен субект';
comment on column public.PartLand.Land_id is 'Земя';
comment on column public.PartLand.SeqNoTS is 'Пор.номер собственик/ползвтел';
comment on column public.PartLand.TypeDeclar is 'Вид дан субект:
1 - собственик
2 - ползвател';
comment on column public.PartLand.DividentLand is 'Делимо';
comment on column public.PartLand.DivisorLand is 'Делител';
comment on column public.PartLand.PartLand is 'част';


--comment on column public.partlandusers.PartLand_Id is 'Ползвател';
--comment on column public.partlandusers is 'Собственик';
comment on column public.partlandusers.DIVIDENT is 'Делимо';
comment on column public.partlandusers.DIVISOR is 'Делител';
comment on column public.partlandusers.PART is 'Част';


comment on column public.PartProperty.Relief_Id is 'Данъчни облекчения';
comment on column public.PartProperty.Property_id is 'Имот';
comment on column public.PartProperty.SeqNoTS is 'Пор.номер собственик/ползвтел
С_1
П_1..';
comment on column public.PartProperty.TaxSubject_Id is 'Задължен субект';
comment on column public.PartProperty.TypeDeclar is 'Вид дан субект:
1 - собственик
2 - ползвател';


comment on column public.PartTransport.PartTransport_Id is 'Собственици на превозни средства';
comment on column public.PartTransport.TaxSubject_Id is 'Задължен субект';
comment on column public.PartTransport.Transport_Id is 'Декларация за член 54';
comment on column public.PartTransport.Divident is 'Делимо';
comment on column public.PartTransport.Divisor is 'Делител';


comment on column public.Patent.Patent_id is 'Патент';
comment on column public.Patent.TaxSubject_Id is 'Задължен субект - Данни за фирмата';
comment on column public.Patent.TaxPeriod_Id is 'Данъчен период';
comment on column public.Patent.IsActivityAppl4 is 'Извършва дейности по приложение 4:
0 - не
1 - да';
comment on column public.Patent.IsTurnover is 'Оборот повече от 50000 лв:
0 - не
1- да';
comment on column public.Patent.IsDDS is 'Регистриран по ДДС:
0 - не
1 - да';
comment on column public.Patent.IsPersonalWork is 'Извършва дейности с личен труд:
0 - не
1 - да';
comment on column public.Patent.BeginDate is 'Дата начало на дейността';
comment on column public.Patent.ChangeDate is 'Дата на промяна на обстоятелствата';
comment on column public.Patent.circumstance1 is 'В рамките на 12 последователни месеца е прекратена патентна дейност и/или е образувано ново предприятие, което извършва патентна дейност и сумарният оборот на двете е повече от 50 000 лв. за 12 последователни месеца:
0 - не
1 - да';
comment on column public.Patent.circumstance1_Date is 'Дата настъпване на обстоятелство1
ГГГГММ';
comment on column public.Patent.circumstance2 is 'В рамките на текущата година оборотът превишава 50 000 лв:
0 - не
1 - да';
comment on column public.Patent.circumstance2_Date is 'Дата настъпване на обстоятелство2
ГГГГММ';
comment on column public.Patent.circumstance3 is 'Регистрация по ЗДДС в рамките на текущата година, с изключение на регистрация за ВОП:
0 - не
1 - да';
comment on column public.Patent.circumstance3_Date is 'Дата настъпване на обстоятелство3
ГГГГММ';
comment on column public.Patent.user_Id is 'Потребител';


comment on column public.PatentActivity.PatentActivity_id is 'Патентна дейност';
comment on column public.PatentActivity.Patent_id is 'Патенти';
comment on column public.PatentActivity.IsWorkAlone is 'Работи без други работници:
0 - не
1 - да';
comment on column public.PatentActivity.IsPersonalWork is 'С личен труд:
0 - не
1 - да';
comment on column public.PatentActivity.IsApprenticeReg is 'Наличие на удостоверение от регистъра за чираците /  за таб 6/:
0 - не
1 - да';
--comment on column public.PatentActivity.TaxValueTotal_Decl is 'Обща стойност на данъка за дейностадекларирана';
--comment on column public.PatentActivity.TaxValueTotal_Calc is 'Обща стойност на данъка за дейностаизчислена';
--comment on column public.PatentActivity.IsFalse_TaxValueTotal is 'Грешно изчислен данък:



comment on column public.PatentActivityObj.PatentActivityObj_id is 'Патентна дейност - обект';
comment on column public.PatentActivityObj.PatentActivityReg_Id is 'Вид на патентна дейност';
comment on column public.PatentActivityObj.PatentZone_Id is 'Зона патент';
comment on column public.PatentActivityObj.PatentActivity_id is 'Патентна дейност';
comment on column public.PatentActivityObj.ObjNo is 'Номер на обект';
comment on column public.PatentActivityObj.ObjMore is 'Още за обекта / Рег номер на МПС/';
comment on column public.PatentActivityObj.ObjAddress is 'Адрес на обекта';
comment on column public.PatentActivityObj.Address_Id is 'Адрес на  обект';
comment on column public.PatentActivityObj.Category is 'Категория на обекта';
comment on column public.PatentActivityObj.Quantity1 is 'Количество1 /общо/:
за таб1 - брой стаи;
за таб17 - 0 - не; 1- да;';
comment on column public.PatentActivityObj.Quantity2 is 'Количество2:
за таб6 - Брой чираци;
за таб17 - 0 - не; 1- да;';
comment on column public.PatentActivityObj.Note is 'Други данни - регистрационни номера, .';
comment on column public.PatentActivityObj.TaxValue_decl is 'Данък в лв. деклариран';
comment on column public.PatentActivityObj.TaxValue_calc is 'Данък в Лв. изчислен включително облекчения';
comment on column public.PatentActivityObj.IsFalse_TaxValue is 'Грешно изчислен данък:
0 - не
1 - да';
comment on column public.PatentActivityObj.FreeTaxVal is 'Облекчение';


comment on column public.PatentActivityReg.PatentActivityReg_Id is 'Вид на патентна дейност';
comment on column public.PatentActivityReg.TableNo is 'Номер на таблица в дан. декларация';
comment on column public.PatentActivityReg.Activity_Fullname is 'Пълно наименование';
comment on column public.PatentActivityReg.Name is 'Съкратено наименование';
comment on column public.PatentActivityReg.RestrictQuantity1 is 'Ограничение за количество:
за таб1 : 20 /брой стаи/
за таб4  : 100 /кв.м/';
comment on column public.PatentActivityReg.MeasureQuantity2 is 'Мярка на количество:
за таб6 -  Брой работни места за чираци
за таб9 - Площ на обекта
за таб13 - Брой места 
за таб17 - Наети лица';
comment on column public.PatentActivityReg.ISRETIREDFREE is 'Облекчение за пенсионери:
1 - да
0 - не';


comment on column public.PatentOther.PatentOther_id is 'Дейност в друга община';
comment on column public.PatentOther.Patent_id is 'Патент';
comment on column public.PatentOther.Municipality_Id is 'Община';
comment on column public.PatentOther.Address_Id is 'Адреси на задължен субект или на обект';
comment on column public.PatentOther.ObjAddress is 'Адрес на обекта
(населено място,  район, ж.к., улица №)';
comment on column public.PatentOther.ActivityName is 'Наименование на дейността';


comment on column public.PatentTaxPrice.City_Id is 'Населено място';
comment on column public.PatentTaxPrice.PatentActivityReg_Id is 'Вид на патентна дейност';
comment on column public.PatentTaxPrice.Municipality_Id is 'Община';
comment on column public.PatentTaxPrice.TaxPeriod_Id is 'Данъчен период';
comment on column public.PatentTaxPrice.CategoryNo is 'Номер на категория или елемент(за т.9)';
comment on column public.PatentTaxPrice.PatentZone_Id is 'Номер на зона';
comment on column public.PatentTaxPrice.TaxPrice is 'Ед. цена';

comment on column public.PatentZone.TaxPeriod_Id is 'Данъчен период';
comment on column public.PatentZone.Municipality_Id is 'Община';
comment on column public.PatentZone.City_Id is 'Населено място';
comment on column public.PatentZone.Street_Id is 'Улица ако улицата е null важи за целия град/освен изрично изредени улици/';



comment on column public.PayDebt.KindDebtReg_Id is 'Код вид задължение';
comment on column public.PayDebt.PayDocument_Id is 'Платежен документ';
comment on column public.PayDebt.Debtinstalment_Id is 'За надвнесени суми е null';
comment on column public.PayDebt.PayInstSum is 'Платена главница';
comment on column public.PayDebt.PayInterestSum is 'Платена лихва';
comment on column public.PayDebt.PayDiscSum is 'Отстъпка';
comment on column public.PayDebt.BalInstSum is 'Дължима главница преди операция';
comment on column public.PayDebt.BalInterestSum is 'Дължима лихва преди операция';


comment on column public.PayDocument.PayDocument_Id is 'Платежен документ';
comment on column public.PayDocument.TaxSubject_Id is 'Задължен субект/Наредител/';
comment on column public.PayDocument.PartidaNo is 'Номер на партида - само за печат на квитанции!';
comment on column public.PayDocument.BAccount_Id is 'платено по/от банкова сметка на общината';
comment on column public.PayDocument.RegDocNo is 'уникален номер документ, генериран от системата';
comment on column public.PayDocument.Series is 'Серия';
comment on column public.PayDocument.DocumentNo is 'Номер документ за ПН от банка';
comment on column public.PayDocument.DocumentDate is 'Дата пл. документ';
comment on column public.PayDocument.PayDate is 'Дата плащане';
comment on column public.PayDocument.PayTime is 'Дата и час на плащане';
comment on column public.PayDocument.DocSum is 'Сума плащане :
със знак';
comment on column public.PayDocument.User_Id is 'Инкасирано от - Поща или събирач';
comment on column public.PayDocument.reason1 is 'Основание';
comment on column public.PayDocument.Reason2 is 'Още пояснения';
comment on column public.PayDocument.Note is 'Забележка';
comment on column public.PayDocument.TSAccount is 'Банкова сметка на наредителя /дан. субект/
/при получ на док може да се актуализира в данните за ДС/';
comment on column public.PayDocument.TSBIC is 'BIC на банкова сметка на наредителя / данъчен субект/';
comment on column public.PayDocument.RECEIVE_TaxSubject_Id is 'Получател на сума по РКО';
comment on column public.PayDocument.Null_date is 'Дата сторниране';
comment on column public.PayDocument.Null_Userdate is 'Системна дата при сторниране';
comment on column public.PayDocument.Null_user_Id is 'Служител сторнирал';
comment on column public.PayDocument.Null_User_name is 'Име на сторнирал';
comment on column public.PayDocument.DocPay is ' Документ, по който се плаща';
comment on column public.PayDocument.DocFromDate is 'Период, за който се плаща От';
comment on column public.PayDocument.DocToDate is 'Период, за който се плаща До';

comment on column public.PayDocument.Over_KindDebtReg_Id is 'Код вид плащане на надвнесена сума
или
Превод по код вид плащане';
comment on column public.PayDocument.From_KindDebtReg_Id is 'Превод от код вид плащане';
comment on column public.PayDocument.RCBIC is 'Банка получател';
comment on column public.PayDocument.RCAccount is 'Сметка получател';


comment on column public.PayTransaction.Municipality_Id is 'Община';
comment on column public.PayTransaction.TransactionNo is 'Номер операция';
comment on column public.PayTransaction.TrDate is 'Дата операция';
comment on column public.PayTransaction.TrSuma is 'Сума операция';
comment on column public.PayTransaction.TrType is 'Тип операция:
1 - Касово плащане
2 - Ежедневно приключване
3 - Изправление,  прихващане, НР -за върнато  с РКО, ПН - сторноРКО
4 - Безкасово плащане от клиенти- банка, събирач, поща
5 - файл-трансфер
9 - Миграция';
comment on column public.PayTransaction.Verified_User_Id is 'Потребител потвърдил
При ПН за връщане - от извлечение
при ПКО - който го е въвел
при квитанции - от извлечение потв. вноски';


comment on column public.Person.Person_Id is 'Лице';
comment on column public.Person.TaxSubject_Id is 'Клиент';
comment on column public.Person.Age is 'век:
0 - 18ХХ
1 - 19ХХ
2 - 20ХХ';
comment on column public.Person.IDN is 'Идентификационен номер - ЕГН/ЛНЧ';
comment on column public.Person.Kind_IDN is 'Вид идинтификатор:
10 - ЕГН
11 - ЛНЧ';
comment on column public.Person.IsForeigner is '1 - чужденец';
comment on column public.Person.Name is 'трите имена';
comment on column public.Person.firstname is 'собствено име';
comment on column public.Person.sirname is 'бащино име';
comment on column public.Person.family_name is 'фамилно име';
comment on column public.Person.Family_Status is 'Семейно положение
1 - неженен
2 - женен
3 - вдовец
4 - разведен
9 - неизвестно';
comment on column public.Person.IDN_mother is 'ЕГН - майка';
comment on column public.Person.indicator_IDN_mother is 'Indikator непопълнено ЕГН:
1 - по неизвестна причина
2 - починала без ЕГН
3 - чужденка
4 - неизвестна';
comment on column public.Person.IDN_father is 'ЕГН - баща';
comment on column public.Person.indicator_IDN_father is 'Indikator непопълнено ЕГН:
1 - по неизвестна причина
2 - починал без ЕГН
3 - чужденец
4 - неизвестен';
comment on column public.Person.IDN_spouse is 'ЕГН - съпруг(а)';
comment on column public.Person.indicator_IDN_spouse is 'Indikator непопълнено ЕГН:
1 - по неизвестна причина
2 - починал/а без ЕГН
3 - чужденец/ка';
comment on column public.Person.Citizenship1_Country_ID is 'Гражданство1';
comment on column public.Person.Citizenship2_Country_ID is 'Гражданство2';
comment on column public.Person.IdentDoc_Kind is 'Вид документ за самоличност:
0 - личен паспорт
1 - удост. на самоличност на чужденец
2 - лична карта на БГ гражданин
3 - карта на пост. пребиваващ чужденец
4 - карта на бежанец';
comment on column public.Person.IdentDocNo is 'Документ номер';
comment on column public.Person.Emission_Date is 'Дата на издаване на документа';
comment on column public.Person.RDVR_Id is 'Издател - РДВР';
comment on column public.Person.Retired_Date is 'Дата пенсиониране';
comment on column public.Person.Dead_Date is 'Дата починал';
comment on column public.Person.Dead_ActNo is 'Номер смъртен акт';
comment on column public.Person.Dead_City_Id is 'населено място на акта за смърт';
comment on column public.Person.Note is 'Забележка';
comment on column public.Person.Input_Code is 'Код произход:
0 - Държавен регисър /ЕСГРАОН/
1 - декларация';



comment on column public.PromTBO.City_Id is 'Населено място';
comment on column public.PromTBO.TaxPeriod_Id is 'Данъчен период';;
comment on column public.PromTBO.IsTBOTax is 'Облагат се имоти до данъчна оценка/отчетна стойност Config.LimTBO(1400лв.):
0 - нe
1 - да';
comment on column public.PromTBO.SW_Home is 'Промил за сметосъбиране и сметоизвозване за жилищни имоти';
comment on column public.PromTBO.Clean_Home is 'Промил за поддържане чистота за жилищни имоти';
comment on column public.PromTBO.Depot_Home is 'Промил за обезвреждане и депо за жилищни имоти';
comment on column public.PromTBO.SW is 'Промил за сметосъбиране и сметоизвозване за нежилищни имоти';
comment on column public.PromTBO.Clean is 'Промил за поддържане чистота за нежилищни имоти';
comment on column public.PromTBO.Depot is 'Промил за обезвреждане и депо за нежилищни имоти';
comment on column public.PromTBO.TBO_Code is 'Код ТБО за имота:
1 - пълен размер; 
3 - без такса;
4 - според количеството;
5 - сметосъбиране и депо;
6 - депо;
7 - депо и чистота;
8 - чистота;
По подразбиране- пълен размер';

comment on column public.Property.Property_id is 'Имот';
comment on column public.Property.Location_Municipality_Id is 'Община - Местонахождение на имота';
comment on column public.Property.SeqNoProperty is 'Пореден номер на имота';
comment on column public.Property.KindProperty is 'Вид на имота
1 - Земя
2 - Сграда(и)
3 - Земя и сграда';
comment on column public.Property.Property_Address_Id is 'Адрес на имота';
comment on column public.Property.EarnWay is 'Начин на придобиване';
comment on column public.Property.PropertyDoc is 'Документ за собственост - вид';
comment on column public.Property.PropDocDate is 'Дата на документ за собственост';
comment on column public.Property.PropertyNoDoc is 'Номер на документ за собственост';
comment on column public.Property.PropEmission is 'Издател на документ за собственост';
comment on column public.Property.PropertyNote is 'Данни за предишния собственник ако не се намира в TaxSubject';
comment on column public.Property.KindLand is 'Код вид земя :/Nzem/
1 - УПИ /парцел/ в строит. граници
2 - УПИ извън строит граници
3 - друг терен в строит.граници
4 - земеделска
5 - горска
6 - друга';
comment on column public.Property.KadastrNo is 'Кадастрален номер';
comment on column public.Property.Kadastr_Year is 'Година на одобряване на кадастр.план';
comment on column public.Property.TaxUnit2 is 'Данъчно поделение по местонахождение на имота';
comment on column public.Property.OneOwner is 'Единствен собсвеник
1 - да
0 - не';
comment on column public.Property.OneUser is 'Единствен ползвател
1 - да
0 - не';
comment on column public.Property.isElectro is 'Електифициран:
1 - има в имота
2 - няма в имота, но има около
3 - няма в имота и около него';
comment on column public.Property.IsWater is 'Водопровод:
1 - има в имота
2 - няма в имота има около
3 - няма в имота и около него';
comment on column public.Property.isSewer is 'Канакизация:
1 - има в имота
2 - няма в имота има около
3 - няма в имота и около него';
comment on column public.Property.isTEC is 'ТЕЦ:
1 - има в имота
2 - няма в имота, има около
3 няма в имота и около него';
comment on column public.Property.IsRoad is 'Пътна мрежа:
1 - граничи с пътна мрежа
0 - не граничи';
comment on column public.Property.Category_City is 'Категория на населеното место:
/FTIP/';
comment on column public.Property.IsNationalResort is 'Национален курорт:
1 - да
0 - не';
comment on column public.Property.IsLocalResort is 'Местен курорт:
1 - да
0 - не';
comment on column public.Property.isSeeZone is 'Вилна зона на 10 км от море:
1 - да
0 - не';
comment on column public.Property.isNationalRoadNet is 'Национална пътна мрежа - до 1 км:
1 - да 
0 - не';
comment on column public.Property.IsIsolatedZone is 'Имот в обособена производствена зона:
1 - да
0 - не';
comment on column public.Property.City_Category1 is 'Населено место от 4,5,6,7,8 категория и на 20 км от н.м. 0,1 категория';
comment on column public.Property.City_Category2 is 'Населено место от 4,5,6,7,8 категория и на 15 км от н.м. 2 категория';
comment on column public.Property.Builder_Zone is 'Строителна зона:
1-- 5';
comment on column public.Property.SeeZone_Cat is 'Категория на вилна зона:
1
2';
comment on column public.Property.ConstructionBound is 'Разположение на имота :
(Строителни граници):
1 - в строителни граници
2 - извън строителни граници';
comment on column public.Property.ZRPNo_District is 'Номер по ЗРП - квартал';
comment on column public.Property.ZRPNo_Parcel is 'Номер по ЗРП - парцел';
comment on column public.Property.ZRP_Date is 'Година на одобряване на ЗРП';
comment on column public.Property.Note is 'Други данни';
comment on column public.Property.StructureZone is 'Код устройствена зона /NUSTRZ/:
1 - централна
2 - жилищна
3 - производствена
4 - друга
5 - селскостопанска
6 - няма обособена';
comment on column public.Property.UsesRight is 'Учредено вещно право на ползване
1 - да
0 - не';
comment on column public.Property.DublProperty is 'Дублиран имот';
comment on column public.Property.Status is 'Статус на декларация за имот:
0 - ОК;
1- не може да се изчисли данъчна оценка;
2 - не може да се разпредели данъка;
3 - и двете;
9 - Закрита партида';
comment on column public.Property.Repl_User_Name is 'Длъжностно лице дало служебната информация';
comment on column public.Property.User_Date is 'Дата на последна корекция';
comment on column public.Property.user_Id is 'Потребител';
comment on column public.Property.ErrorData is 'Грешки при съставяне на документа';
comment on column public.Property.CodeTBO is 'Код ТБО за имота: 
3-без такса;
5- сметосъбиране и депо;
6- депо;
7-депо и чистота;
8- чистота;
9- различен  промил;';
comment on column public.Property.Promil is 'Стойност на промил / ако е различен/';
comment on column public.Property.OneSender is 'Подадена декл. от друг собственик или ползвател? Eдинствено приложение /няма подадено от друг собственик/:
0 - не
1 - да';
comment on column public.Property.InCharge is 'Длъжностно лице';



comment on column public.Province.Province_Id is 'Област';
comment on column public.Province.EKKATE is 'Код по единния класификатор';
comment on column public.Province.Name is 'Наименование на област';
comment on column public.Province.Code is 'Код на областа';


comment on column public.RDVR.RDVR_Id is 'РДВР';
comment on column public.RDVR.Code is 'Номер';
comment on column public.RDVR.Name is 'Наименование на РДВР';
comment on column public.RDVR.Address is 'Адрес на РДВР';


comment on column public.ReasonReg.ReasonReg_Id is 'Основание';
comment on column public.ReasonReg.Municipality_Id is 'Община';
comment on column public.ReasonReg.DocumentType_Id is 'Тип документ';
comment on column public.ReasonReg.Reason_Kind is 'Вид основание - напр
1-/Give_Reason/ основание за подаване декларация
2- основание за освобождаване от данък
3- Основание за облекчение на данък
4 - Основание за закриване';
comment on column public.ReasonReg.Reason_Code is 'Код основание: /за по-бързо избиране вместо текст/
01
02
03..';


comment on column public.RegNumber.incNo_From is 'Входящ номер - начален';
comment on column public.RegNumber.incNo_To is 'Входящ номер - краен';
comment on column public.RegNumber.incNo_last is 'Входящ номер - последно издаден';
comment on column public.RegNumber.outNo_From is 'Изходящ номер - начален';
comment on column public.RegNumber.outNo_To is 'Изходящ номер - краен';
comment on column public.RegNumber.outNo_last is 'Изходящ номер - последно издаден';
comment on column public.RegNumber.series is 'Серия - за квитанции';


comment on column public.Relief.Relief_Id is 'Данъчни облекчения';
comment on column public.Relief.TaxSubject_Id is 'клиент';
comment on column public.Relief.IsRetired is 'Пенсионер:
0-не;
1 - да;
Само при ФЛ';
comment on column public.Relief.Retired_BeginDate is 'Дата пенсиониране от';
comment on column public.Relief.Retired_EndDate is 'Дата пенсиониране до';
comment on column public.Relief.TELK_DecisionDate is 'Дата на издаванеТЕЛК';
comment on column public.Relief.TELK_DecisionNo is 'Номер на решениеТЕЛК';
comment on column public.Relief.TELK_BeginDate is 'ТЕЛК в сила от дата';
comment on column public.Relief.TELK_EndDate is 'ТЕЛК в сила до дата';
comment on column public.Relief.Note is 'Забележка';


comment on column public.representative.representative_Id is 'Представляващ';
comment on column public.representative.TaxSubject_Id is 'Клиент';
comment on column public.representative.representativeNo is 'Номер по ред';
comment on column public.representative.Kind_IDN is 'Вид идинтификатор:
20 - ЕИК
21 - БУЛСТАТ
10 - ЕГН
11 - ЛНЧ';
comment on column public.representative.IDN is 'Единен идентификационен код (ЕГН/ЛНЧ/БУЛСТАТ/ЕИК)';
comment on column public.representative.Name is 'Име на представляващ';
comment on column public.representative.Input_Code is 'Код произход:
0 - ЕСГРАОН/ БУЛСТАТ
1 - декларация';
comment on column public.representative.StatusRepr is 'Тип на представителя:
1 - МОЛ
9 - Неактивен';








comment on column public.Request.Request_Id is 'Молби, искания, заявления';
comment on column public.Request.Municipality_Id is 'Община';
comment on column public.Request.TaxSubject_Id is 'Заявител';
comment on column public.Request.DocNo is 'Входящ номер = RegNumber.IncNo_Last+1';
comment on column public.Request.DocDate is 'Дата документ';

comment on column public.Request.WorkDate is 'Краен срок- дата';
comment on column public.Request.Sum is 'Стойност на услугата';
comment on column public.Request.Note is 'Забележка -при приемане';
comment on column public.Request.Direction_user_Id is 'За изпълнение от:
Код инспектор, към когото е резолирано за обработка искането';


comment on column public.Request.Status is 'Статус на искането';
comment on column public.Request.EndWaitDate is 'Крайна дата за изчакване на заявителя;
След този срок трябва да се предаде в архив, необработено.';
comment on column public.Request.DocExtNo is 'Входящ номер от друга деловодна система';
comment on column public.Request.DocExtDate is 'дата от друга деловодна система';
comment on column public.Request.user_Id is 'Потребител';
comment on column public.Request.User_date is 'Дата на въвеждане в регистъра';
comment on column public.Request.Other is 'Специфични данни';

comment on column public.Request.TaxAccNo is 'Уникален номер на партида
ген. от системата';

comment on column public.Request.Emp_TaxSubject_Id is 'Пълномощник';
comment on column public.Request.EMP_EMISSIONDATE is 'Дата пълномощно';
comment on column public.Request.EMPNO is 'Номер пълномощно';
comment on column public.Request.EMP_CERTIFY is 'Заверил пълномощното';
comment on column public.Request.FORREASON is 'Удостоверение е необходимо за';
comment on column public.Request.FORORGANIZATION is 'Удостоверение да послужи пред';
comment on column public.Request.REQDOCDATE is 'Дата искане';


comment on column public.Resolution.Resolution_Id is 'Решение';
--comment on column public.Resolution.Request_Id is 'Молби, искания, заявления';
--comment on column public.Resolution.resolution_Date is 'Дата на решение';
comment on column public.Resolution.resolutionCode is 'Код решение
Удовлетворено искане:
1 - да
0 - не';
comment on column public.Resolution.conclusion is 'Заключение';
comment on column public.Resolution.Executedate is 'Дата изпълнение';
comment on column public.Resolution.Anotation is 'Анотация';
comment on column public.Resolution.Note is 'Забележка';
comment on column public.Resolution.editionCode is 'Код на издал решение';
comment on column public.Resolution.editionName is 'Име на издал решени';





comment on column public.ServGroup.Name is 'Съкратено име на групата';
comment on column public.ServGroup.FullName is 'Име на групата';



comment on column public.ServiceReg.Municipality_Id is '??????Община';
comment on column public.ServiceReg.IsPay is 'Платена услуга:
0 - не
1 - да';
comment on column public.ServiceReg.ServTerm is 'Обикновена услуга - срок в брой дни;
Когато услугата не се предлага като обикновена, полето е NULL; Стойност 0 означава Веднага';






comment on column public.street.Street_Id is 'Улица';
comment on column public.street.City_Id is 'град';
comment on column public.street.Name is 'Име на улица';
comment on column public.street.Kind_Street is 'Вид - улица, площад, булевард, ..';
comment on column public.street.EKKPA is 'Код по единния класификатор';

comment on column public.StreetChange.CityNo is 'Код на насер.лено място';
comment on column public.StreetChange.StreetNo is 'Код на улица';
comment on column public.StreetChange.KindChange is 'Вид промяна:
ДПА - Откриване (добавяне) на пътна артерия
ИПА - Закриване (изтриване ) на пътната артерия
КПА - Коригиране на името на пътната артерия';
comment on column public.StreetChange.date_Corr is 'Дата последна актуализация';


comment on column public.TabInheritance.Tabinheritance_Id is 'Имущества и задължения /таблици/';
comment on column public.TabInheritance.Inheritance_Id is 'Данък върху наследство';


comment on column public.TaxDoc.Municipality_Id is ' Компетентна община';
comment on column public.TaxDoc.TaxSubject_Id is 'Данъчен субект /Декларатор /';
comment on column public.TaxDoc.KindDecl is 'Тип декларатор:
1- собственик
2 - ползвател
3 - концесионер
4 - законен представител
5 - упълномощено лице';
comment on column public.TaxDoc.TaxObjNo is 'Уникален номер на Данъчен обект';
comment on column public.TaxDoc.Old_PartidaNo is 'Стар партиден номер';
comment on column public.TaxDoc.DocumentType_Id is 'Тип на документ';
comment on column public.TaxDoc.TaxDocDate is 'Дата на декларация/попълнена от декларатора/';
comment on column public.TaxDoc.DocNo is 'Входящ номер = RegNumber.IncNo_Last+1';
comment on column public.TaxDoc.DocExtNo is 'Входящ номер, издаден от друга деловодна система';
comment on column public.TaxDoc.Doc_Date is 'Дата входящ номер = Дата на подаване/приемане на декларацията';
comment on column public.TaxDoc.DocExt_Date is 'Дата вх.номер-външен';
comment on column public.TaxDoc.Earn_Date is 'Дата придобиване на имуществото';
comment on column public.TaxDoc.Emp_TaxSubject_Id is 'Пълномощник';
comment on column public.TaxDoc.EmpNo is 'Номер пълномощно';
comment on column public.TaxDoc.Emp_EmissionDate is 'Дата пълномощно';
comment on column public.TaxDoc.Emp_certify is 'Заверил пълномощното';
comment on column public.TaxDoc.Give_ReasonReg_Id is 'Основание за подаване на декларация:';
comment on column public.TaxDoc.Relief_Id is 'Данъчни облекчения';
comment on column public.TaxDoc.DocWork_FinalDate is 'Краен срок на обработка на декларация';
comment on column public.TaxDoc.Receiver_Date is 'Дата регистрация на документ';
comment on column public.TaxDoc.Receiver_Note is 'Забележка при приемане';
comment on column public.TaxDoc.DocInput_Date is 'Дата въвеждане на декларация = Дата на обработка на декларацията';
comment on column public.TaxDoc.Note is 'Забележка 
За дек. 49: при основание за придобиване друг способ - записва се  техт как именно';
comment on column public.TaxDoc.DocStatus is 'Статус на декларация:
10 - Регистрирана
15 - Резолюция към
20 - Изпратено съобщение за явяване
21 - Връчено съобщение за явяване
30 - Обработена
31 - Необработена за архивиране
50 - Обработена  в архив
51 - Необработена  в архив';
comment on column public.TaxDoc.Close__ReasonReg_Id is 'Основание за закриване на декларация';
comment on column public.TaxDoc.Close_Date is 'Дата закриване';
comment on column public.TaxDoc.Close_TaxDoc_id is 'Id декларация за закриване на партида';
comment on column public.TaxDoc.TO_User_Id is 'Декл. е насочена за обработка към Испектор - User_id';
comment on column public.TaxDoc.Location_Doc is 'Местонахождението на декларацията
/кашон/';
comment on column public.TaxDoc.IsInheritance is 'Данъчният обект е придобит по наследство:
0 - не
1 - да';
comment on column public.TaxDoc.User_Date is 'Дата последно състояние';
comment on column public.TaxDoc.User_Id is 'Служител приел документ';
comment on column public.TaxDoc.User_Name is 'Име инспектор по последно състояние';
comment on column public.TaxDoc.BeginTaxDate is 'Начална дата на облагане на декларацията';
comment on column public.TaxDoc.EndTaxDate is 'Крайна дата на облагане по тази декларация';
comment on column public.TaxDoc.IsInvalid is 'Деклрацията е невалидна:
 1- да
 null 0 - не
/напр. коригираната ф-ра по чл.14 става невалидна/';
comment on column public.TaxDoc.Last_Message_Id is 'Последно съобщение';



comment on column public.TaxObject.Municipality_Id is 'Община';
comment on column public.TaxObject.TaxObjNo is 'Уникален номер на обекта
ген. от системата:
EBK_CODE || Пор.номер';
comment on column public.TaxObject.KindTaxObject is 'Вид обект:
1 - имот
2 - ПС';
comment on column public.TaxObject.Address_Id is 'Адреси на задължен субект или на обект';
comment on column public.TaxObject.KindProperty is 'Вид на имот';
comment on column public.TaxObject.TranspMeansReg_Id is 'превозно средство';
comment on column public.TaxObject.CarReg_Id is 'Модел/Марка ПС';


comment on column public.TaxPeriod.TaxPeriod_Id is 'Данъчен период';
comment on column public.TaxPeriod.Begin_Date is 'От дата';
comment on column public.TaxPeriod.End_Date is 'До дата';
comment on column public.TaxPeriod.TaxPerKind is 'Вид данъчен период:
0 - годишен
1 - тримесечен';





comment on column public.TaxPeriodPay.DocumentType_Id is 'Тип документ';
comment on column public.TaxPeriodPay.TaxPeriod_Id is 'Данъчен период';


comment on column public.TaxSubject.TaxSubject_Id is 'Задължен субект';
comment on column public.TaxSubject.TaxSubjectNo is 'Уникален номер задължен субект
ген.от системата
ЕЕЕЕ S N
ЕЕЕЕ - Код община по ЕБК
 S - Данъчен субект
 N - номер';
comment on column public.TaxSubject.Name is 'Наименование';
comment on column public.TaxSubject.IDN is 'ЕГН/БУЛСТАТ';
comment on column public.TaxSubject.Kind_IDN is 'Вид идинтификатор:
21 - БУЛСТАТ
10 - ЕГН
11 - ЛНЧ';
comment on column public.TaxSubject.TaxNo is 'Данъчен номер';
comment on column public.TaxSubject.TSAccount is 'Банкова сметка на данъчен субект';
comment on column public.TaxSubject.IsPerson is '1 - физическо лице, 0 - юредическо лице';
comment on column public.TaxSubject.present_ClientAddr_Id is 'настоящ адрес';
comment on column public.TaxSubject.present_AddrDate is 'дата на постоянен адрес';
comment on column public.TaxSubject.Permanent_Addres_Exist is 'Наличие на постоянен адрес
0 - не
1 - да';
comment on column public.TaxSubject.permanent_ClientAddr_Id is 'постоянен адрес';
comment on column public.TaxSubject.permanent_AddrDate is 'дата постоянен адрес';
comment on column public.TaxSubject.post_ClientAddr_Id is 'адрес за кореспонденция';
comment on column public.TaxSubject.post_AddrDate is 'дата адрес за кореспонденция';
comment on column public.TaxSubject.Note is 'Забележка';
comment on column public.TaxSubject.PermAddr_Input_Code is 'Код произход:
0- Държавен регисър /ЕСГРАОН, БУЛСТАТ/
1- декларация';
comment on column public.TaxSubject.User_date is 'Дата въвеждане или  корекциья на данни';
comment on column public.TaxSubject.user_Id is 'Потребител';





comment on column public.TranspMeansReg.TranspMeansReg_Id is 'превозно средство';
comment on column public.TranspMeansReg.Code is 'Код превозно средство';
comment on column public.TranspMeansReg.Name is 'Наименование на превозно средство';
comment on column public.TranspMeansReg.Type is 'Тип транспортно средство:
1 - лек автомобил
2 - пр.ср. без лек автомобил
3 - плавателно ср.
4 - въздухоплавателно ср.';


comment on column public.Transport.Transport_Id is 'Декларация за член 54';
comment on column public.Transport.RegNo is 'Регистрационен номер';
comment on column public.Transport.RegNo_Old is 'Стар регистрационен номер';
comment on column public.Transport.CarReg_Id is 'Марка и модел на превозно средство';
comment on column public.Transport.TranspMeansReg_Id is 'Вид превозно средство';
comment on column public.Transport.Reduce_ReasonReg_Id is 'Основание за облекчение на данък
алтернативно или кумулативно?';
comment on column public.Transport.Free_ReasonReg_Id is 'Основание за освобождаване от данък
алтернативно или кумулативно?';
comment on column public.Transport.From_TaxSubject_Id is 'Предишния собственник';
comment on column public.Transport.Acquire_From is 'Начин на придобиване';
comment on column public.Transport.AcquireDoc is 'Документ за придобиване';
comment on column public.Transport.AcquireNote is 'Данни за предишния собственник ако не се намира в TaxSubject';
comment on column public.Transport.Motion_BeginDate is 'Дата на пускане в движение';
comment on column public.Transport.Motion_EndDate is 'Дата спиране от движение /ММ.ГГГГ/';
comment on column public.Transport.CarStatus is 'Състояние на превозно средство:
1 - продадено /5/
2 - уничтожено /6/
3 - откраднато /7/';
comment on column public.Transport.FirstReg_Year is 'Година на първа регистрация';
comment on column public.Transport.City_RDVR_Id is 'РДВР /Град/ в който е рег.колата';
comment on column public.Transport.Tmodify is 'модификация';
comment on column public.Transport.gate_number is 'Брой врати';
comment on column public.Transport.axes_number is 'Брой оси';
comment on column public.Transport.Kind_fuel is 'Вид гориво:
1 - бензин
2 - дизел';
comment on column public.Transport.Motor_Capacity is 'Обем двигател';
comment on column public.Transport.power_KW is 'Мощност квт';
comment on column public.Transport.HorsePower is 'Мощност КС';
comment on column public.Transport.produce_Year is 'Година на производство';
comment on column public.Transport.RamaNo is 'Номер шаси';
comment on column public.Transport.motorNo is 'Номер на двигател';
comment on column public.Transport.Loading_Capacity is 'Товароносимост';
comment on column public.Transport.Tonnage is 'товароподемност';
comment on column public.Transport.KindHanging is 'Вид окачване';
comment on column public.Transport.Max_mass is 'Максимална маса за товарни авт над 12т';
comment on column public.Transport.Max_mass_comp is 'Максимална маса за състав от превозни средства';
comment on column public.Transport.Brutto_Ton is ' Брутотонаж /542/';
comment on column public.Transport.Air_weight is 'Макс. излетно тегло';
comment on column public.Transport.CustHEntryNo is 'Номер на митническа декларация';
comment on column public.Transport.CustHEntry_Date is 'Дата на митническа декларация';
comment on column public.Transport.Katalizator is 'Катализатор:
0-не
1-да';
comment on column public.Transport.Katalizator_Date is 'Дата катализатор';
comment on column public.Transport.ECO_Motor is 'Наличие на екодвигател:
1 - да
0 - не';
comment on column public.Transport.Amb_Car is 'линейка:
1- да
0- не';
comment on column public.Transport.Budget is 'Собственост на държавен/Общ. орган със спец. движение:
1- да
0- не';
comment on column public.Transport.Diplomat is 'Собственост на дипломатическо/консулско представителство:
1- да
0- не';
comment on column public.Transport.BCK is 'Собственост на БЧК:
1- да
0- не';
comment on column public.Transport.public_transport is 'Обществен транспорт:
1- да
0- не';
comment on column public.Transport.user_Id is 'Потребител';
comment on column public.Transport.ErrorData is 'Грешни данни в записа';
comment on column public.Transport.Weigth_Total is 'Общо тегло';
comment on column public.Transport.gain_Date is 'Дата на придобиване на ПС';
comment on column public.Transport.IsDefect is 'Придобит в техническа неизправност:
0 - не
1 - да';
comment on column public.Transport.StealDocNo is 'Документ номер за откраднато ПС';
comment on column public.Transport.StealDocDate is 'Дата до която е в сила документ за откраднато ПС';
comment on column public.Transport.PaidPODate is 'Платено от предишния собктвеник до дата';
comment on column public.Transport.MaxPossible_Mass is 'Максимална технически допустима маса';



comment on column public.TruckTaxPrice.Municipality_Id is 'Община';
comment on column public.TruckTaxPrice.TaxPeriod_Id is 'Данъчен период';
comment on column public.TruckTaxPrice.TranspMeansReg_Id is 'превозно средство';
comment on column public.TruckTaxPrice.axes_number is 'Брой оси';
comment on column public.TruckTaxPrice.SeqNumber is 'Пореден номер интервал за оси';
comment on column public.TruckTaxPrice.MaxMassFrom is 'Доп.макс.маса от';
comment on column public.TruckTaxPrice.MaxMassTo is 'Доп.макс.маса до';
comment on column public.TruckTaxPrice.HangingPFrom is 'За пневм.окачване Размер на данъка от';
comment on column public.TruckTaxPrice.HangingPTo is 'За пневм.окачване Размер на данъка до';
comment on column public.TruckTaxPrice.HangingPTax is 'За пневм.окачване Цена на данъка в лв';
comment on column public.TruckTaxPrice.HangOtherFrom is 'За друго окачване Размер на данъка от';
comment on column public.TruckTaxPrice.HangOtherTo is 'За друго окачване Размер на данъка до';
comment on column public.TruckTaxPrice.HangOtherTax is 'За друго окачване Цена на данъка в лв';


comment on column public.TVBuilding.TVBuilding_id is 'Сграда';
comment on column public.TVBuilding.TVProperty_id is 'Имот';
comment on column public.TVBuilding.SeqNoBuilding is 'Пореден номер сграда';
comment on column public.TVBuilding.KindFunction is 'Предназначение на сграда:
1 - Къща, вила, лятна кухня
2 - Жилищен блок
3 - Гараж /самостоятелна сграда/
4 - Друга второстепенна сграда
5 - Търговска
6 - Производствена
7 - Селскостопанска
8 - Друга нежилищна';
comment on column public.TVBuilding.FloorNumber is 'Брой етажи';
comment on column public.TVBuilding.FloorNumOver is 'Брой етажи над земята';
comment on column public.TVBuilding.Elevator is 'Асансьор
0 - не
1 - да';

comment on column public.TVBuilding.Note is 'Забележка';
comment on column public.TVBuilding.User_id is 'Код служител въвел информацията';
comment on column public.TVBuilding.UserDate is 'Дат на последна актуализация';



comment on column public.TVHomeObj.TVHomeObj_id is 'Жилищни обекти';
comment on column public.TVHomeObj.TVBuilding_id is 'Сграда';
comment on column public.TVHomeObj.Function is 'Предназначение на обекта
/ текст/';
comment on column public.TVHomeObj.SeqNoObj is 'Пореден номер обект';
comment on column public.TVHomeObj.KindHomeObjReg_Id is 'Вид обект /NVIDOB/';
comment on column public.TVHomeObj.BuildDate is 'Година на построяване';
comment on column public.TVHomeObj.ObjectArea is 'Разгъната застроена площ(РЗП) на обекта';
comment on column public.TVHomeObj.CellerArea is 'РЗП на мазе в кв.м.';
comment on column public.TVHomeObj.AtticArea is 'РЗП на таван в кв.м.';
comment on column public.TVHomeObj.TotalArea is 'Общо РЗП';
comment on column public.TVHomeObj.Floor is 'Етаж';
comment on column public.TVHomeObj.isBusiness is 'Стопанска цел:
0 - не
1 - да';
comment on column public.TVHomeObj.Height is 'Височина';
comment on column public.TVHomeObj.KindConstruction is 'Вид на конструкция /NVKON/ :
ПН - паянтова;
ПМ - полумасивна
М1 - масивна без ..
М2 - панелна
М3 - масивни монолитни';
comment on column public.TVHomeObj.isElectro is 'Електрифициран:
0 - не
1 - да';
comment on column public.TVHomeObj.isWater is 'Водопровод:
0 - не
1 - да';
comment on column public.TVHomeObj.isSewer is 'Канализация:
0 - не
1 - да';
comment on column public.TVHomeObj.isTEC is 'Топлофициран:
0 - не
1 - да';
comment on column public.TVHomeObj.isTelefon is 'Телефон:
0 - не
1 - да';
comment on column public.TVHomeObj.RepairDate is 'Година на основен ремонт';
comment on column public.TVHomeObj.isHeating is 'Отоплителна инсталация:
0 - не
1 - да';
comment on column public.TVHomeObj.isAircondition is 'Климатична инсталация:
0 - не
1 - да';
comment on column public.TVHomeObj.LuxWindow is 'Луксозна дограма:
0 - не
1 - да';
comment on column public.TVHomeObj.SoundInsulation is 'Звукова или топлинна изолация:
0 - не
1 - да';
comment on column public.TVHomeObj.SpecialRoof is 'Специално покривно покритие:
0 - не
1 - да';
comment on column public.TVHomeObj.LuxDecorate is 'Луксозни декоративни елементи и облицовки:
0 - не
1 - да';
comment on column public.TVHomeObj.User_id is 'код служител въвел информацията';
comment on column public.TVHomeObj.User_Date is 'Дата на последна актуализация';
comment on column public.TVHomeObj.dividend is 'Идеална част - Делимо';
comment on column public.TVHomeObj.divisor is 'Идеална част - делител';
comment on column public.TVHomeObj.Part is 'Идеална част - десетична дроб';
comment on column public.TVHomeObj.UseArea is 'Площ в кв.м. върху, която е учредено ПП';
comment on column public.TVHomeObj.TaxValue is 'Данъчна оценка';


comment on column public.TVLand.TVLand_id is 'Земя';
comment on column public.TVLand.TVProperty_id is 'Имот';
comment on column public.TVLand.TypeDeclar is 'Тип декларатор  - собственик/Ползвател:
1 - Собственик на земята
2 - Ползвател на земята';
comment on column public.TVLand.BuildingOwner is 'Собственик на сграда върху общински терен:
0 - не
1 - да';
comment on column public.TVLand.LandArea is 'Площ на земята в кв. м.';
comment on column public.TVLand.BuiltUpArea is 'Застроена площ в кв.м.';
comment on column public.TVLand.IsFence is 'Наличие на масивна ограда:
0 -  не
1 -  да';
comment on column public.TVLand.FenceHeight is 'Височина на масивна ограда';
comment on column public.TVLand.FenceLength is 'Дължина на масивна ограда в м.';
comment on column public.TVLand.IsCovering is 'Наличие на трайна настилка:
0 -  не
1 -  да';
comment on column public.TVLand.CoveringArea is 'Площ на трайна настилка в кв. м.';
comment on column public.TVLand.IsSportCovering is 'Наличие на спортна площадка с трайна настилка:
0 -  не
1 -  да';
comment on column public.TVLand.SportArea is 'Площ на спортна площадка с трайна настилка в кв.м.';
comment on column public.TVLand.IsPool is 'Наличие на басейн:
0 -  не
1 -  да';
comment on column public.TVLand.PoolCapacity is 'Обем на басейн  в куб.м.';
comment on column public.TVLand.IsGreenParking is 'Наличие на аркинг за обществено ползване зелени:
0 -  не
1 -  да';
comment on column public.TVLand.GreenParking is 'Площ на паркинг за обществено ползване зелени в кв.м.';
comment on column public.TVLand.IsParking is 'Наличие на всички останали паркинги:
0 -  не
1 -  да';
comment on column public.TVLand.ParkingArea is 'Площ на всички останали паркинги в кв.м.';
comment on column public.TVLand.IsBusiness is 'Имота се ползва със стопанска цел
0 - не
1 - да';
comment on column public.TVLand.User_id is 'Служител въвел информацията';
comment on column public.TVLand.User_Date is 'Дата последна корекция';
comment on column public.TVLand.KindLand is 'Вид на земята - земеделска, горска';
comment on column public.TVLand.UseRightDate is 'Учредяване на ПП от месец';
comment on column public.TVLand.UseRightTerm is 'Срок на ПП - 0 - безсрочно';
comment on column public.TVLand.Age is 'Възраст на най-младия ползвател';
comment on column public.TVLand.Divident is 'Идеална част - делимо';
comment on column public.TVLand.Divisor is 'Идеална част - делител';
comment on column public.TVLand.Part is 'Идеална част - десетична дроб';
comment on column public.TVLand.UseArea is 'Площ в кв.м. върху, която е учредено ПП';
comment on column public.TVLand.TaxValue is 'Данъчна оценка';


comment on column public.TVPartHomeObj.SeqNoTS is 'Пор.номер собственик/ползвтел';
comment on column public.TVPartHomeObj.TVHomeObj_id is 'Жилищни обекти';
comment on column public.TVPartHomeObj.TaxSubject_Id is 'Задължен субект';
comment on column public.TVPartHomeObj.TypeDeclar is 'Вид дан субект:
1 - собственик
2 - ползвател';
comment on column public.TVPartHomeObj.isBaseHome is 'Основно жилище:
0 - не
1 - да';
comment on column public.TVPartHomeObj.Divident is 'Делимо';
comment on column public.TVPartHomeObj.Divisor is 'Делител';


comment on column public.TVPartLand.TaxSubject_Id is 'Задължен субект';
comment on column public.TVPartLand.TVLand_id is 'Земя';
comment on column public.TVPartLand.SeqNoTS is 'Пор.номер собственик/ползвтел';
comment on column public.TVPartLand.TypeDeclar is 'Вид дан субект:
1 - собственик
2 - ползвател';
comment on column public.TVPartLand.DividentLand is 'Делимо';
comment on column public.TVPartLand.DivisorLand is 'Делител';
comment on column public.TVPartLand.PartLand is 'част';


comment on column public.TVPartProperty.TVProperty_id is 'Имот';
comment on column public.TVPartProperty.SeqNoTS is 'Пор.номер собственик/ползвтел
С_1
П_1..';
comment on column public.TVPartProperty.TaxSubject_Id is 'Задължен субект';
comment on column public.TVPartProperty.TypeDeclar is 'Вид дан субект:
1 - собственик
2 - ползвател';



comment on column public.TVProperty.TVProperty_id is 'Имот';
comment on column public.TVProperty.KindProperty is 'Вид на имота
1 - Земя
2 - Сграда(и)
3 - Земя и сграда';
comment on column public.TVProperty.Property_Address_Id is 'Адрес на имота';
comment on column public.TVProperty.KindLand is 'Код вид земя :/Nzem/
1 - УПИ /парцел/ в строит. граници
2 - УПИ извън строит граници
3 - друг терен в строит.граници
4 - земеделска
5 - горска
6 - друга';
comment on column public.TVProperty.KadastrNo is 'Кадастрален номер';
comment on column public.TVProperty.Kadastr_Year is 'Година на одобряване на кадастр.план';
comment on column public.TVProperty.isElectro is 'Електифициран:
1 - има в имота
2 - няма в имота, но има около
3 - няма в имота и около него';
comment on column public.TVProperty.IsWater is 'Водопровод:
1 - има в имота
2 - няма в имота има около
3 - няма в имота и около него';
comment on column public.TVProperty.isSewer is 'Канакизация:
1 - има в имота
2 - няма в имота има около
3 - няма в имота и около него';
comment on column public.TVProperty.isTEC is 'ТЕЦ:
1 - има в имота
2 - няма в имота, има около
3 няма в имота и около него';
comment on column public.TVProperty.IsRoad is 'Пътна мрежа:
1 - граничи с пътна мрежа
0 - не граничи';
comment on column public.TVProperty.Category_City is 'Категория на населеното место:
/FTIP/';
comment on column public.TVProperty.IsNationalResort is 'Национален курорт:
1 - да
0 - не';
comment on column public.TVProperty.IsLocalResort is 'Местен курорт:
1 - да
0 - не';
comment on column public.TVProperty.isSeeZone is 'Вилна зона на 10 км от море:
1 - да
0 - не';
comment on column public.TVProperty.isNationalRoadNet is 'Национална пътна мрежа - до 1 км:
1 - да 
0 - не';
comment on column public.TVProperty.IsIsolatedZone is 'Имот в обособена производствена зона:
1 - да
0 - не';
comment on column public.TVProperty.Builder_Zone is 'Строителна зона:
1-- 5';
comment on column public.TVProperty.SeeZone_Cat is 'Категория на вилна зона:
1
2';
comment on column public.TVProperty.ConstructionBound is 'Разположение на имота :
(Строителни граници):
1 - в строителни граници
2 - извън строителни граници';
comment on column public.TVProperty.ZRPNo_District is 'Номер по ЗРП - квартал';
comment on column public.TVProperty.ZRPNo_Parcel is 'Номер по ЗРП - парцел';
comment on column public.TVProperty.ZRP_Date is 'Година на одобряване на ЗРП';
comment on column public.TVProperty.Note is 'Други данни';
comment on column public.TVProperty.User_Date is 'Дата на последна корекция';
comment on column public.TVProperty.user_Id is 'Потребител';
comment on column public.TVProperty.ObjectArea is 'Площ на обекта /за земеделска земя и за право на строеж /';


comment on column public.TVTaxDoc.Municipality_Id is 'община';
comment on column public.TVTaxDoc.TaxSubject_Id is 'Данъчен субект /Декларатор /';
comment on column public.TVTaxDoc.KindDecl is 'Тип декларатор:
1- собственик
2 - ползвател
3 - концесионер
4 - законен представител
5 - упълномощено лице';
comment on column public.TVTaxDoc.PartidaNo is 'Партиден номер от имотите на ДЗЛ';
comment on column public.TVTaxDoc.DocumentType_Id is 'Тип на документ';
comment on column public.TVTaxDoc.TaxDocDate is 'Дата на декларация/попълнена от декларатора/';
comment on column public.TVTaxDoc.DocNo is 'Входящ номер = RegNumber.IncNo_Last+1';
comment on column public.TVTaxDoc.Doc_Date is 'Дата входящ номер = Дата на подаване/приемане на декларацията';
comment on column public.TVTaxDoc.Note is 'Забележка 
За кого е предназначено удостоверението';
comment on column public.TVTaxDoc.User_Date is 'Дата последно състояние';
comment on column public.TVTaxDoc.User_Id is 'Служител приел документ';
comment on column public.TVTaxDoc.User_Name is 'Име инспектор по последно състояние';
comment on column public.TVTaxDoc.KindTaxVal is 'Вид ДО';
comment on column public.TVTaxDoc.ValidTerm is 'Срок на валидност (до дата)';
comment on column public.TVTaxDoc.OutDocType is 'Тип на изходния документ
- Удостоверение
- Уведомление';
comment on column public.TVTaxDoc.UseRightDate is 'Учредяване на право на ползване от месец';
comment on column public.TVTaxDoc.UseRightTerm is 'Срок на правото на ползване, 0 - безсрочно';
comment on column public.TVTaxDoc.Age is 'Възраст на най-младия ползвател, 0 за фирми';
comment on column public.TVTaxDoc.PctFinished is 'Процент на завършеност на сградата';
comment on column public.TVTaxDoc.BuildRightDate is 'Право на строеж от месец';
comment on column public.TVTaxDoc.BuildRightTerm is 'Срок на право на строеж - брой години
(0 - безсрочно)';
comment on column public.TVTaxDoc.RoadDistance is 'Разстояние до пътна мрежа';
comment on column public.TVTaxDoc.ConstrBoundDistance is 'Разстояние до строителни граници на
населено место';
comment on column public.TVTaxDoc.Category is 'Категория на земята';
comment on column public.TVTaxDoc.Conditions is 'Условия';
comment on column public.TVTaxDoc.KindUse is 'Начин на ползване';
comment on column public.TVTaxDoc.PURPOSE is 'Да послужи пред';
comment on column public.TVTaxDoc.NecessaryFor is 'Необходима във връзка';

comment on column public.Users.Municipality_Id is 'Община';
comment on column public.Users.USERNAME is 'Име';
comment on column public.Users.Begin_Date is 'От дата';
comment on column public.Users.End_Date is 'до дата';
comment on column public.WorkHistory.Municipality_Id is 'Община';
comment on column public.WorkHistory.DocumentType_Id is 'Тип документ';
comment on column public.WorkHistory.Document_Id is 'Идентификатор на декларация / искане (Taxdoc_id или Request_id)';
comment on column public.WorkHistory.WorkType is 'Клас действие';
comment on column public.WorkHistory.WorkCode is 'Код на действието';
comment on column public.WorkHistory.Work_Date is 'Дата на действието:
-Дата на връчване на съобщението за явяване
-Дата на изготвяне на документа
- Дата на връчване на документа';
comment on column public.WorkHistory.Note is 'Други данни';
comment on column public.WorkHistory.Direction_User_Id is 'Код на инспектор, към когото е резолирано за изпълнение(клас 15)';
comment on column public.WorkHistory.Direction_User_Name is 'Име на инспектор, към когото е резолирано за изпълнение(клас 15)';
comment on column public.WorkHistory.user_Id is 'Код инспектор, извършил действието.
В случаите различни от обработка инспектор извършил действието = инспектор извършил записа';
