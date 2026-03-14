# Part 1.3 - Trang Bi Hao Mon

## Muc tieu
Bo sung co che hao mon cho trang bi (sword, shield) trong khi van giu code ben ngoai trong suot.

## Thiet ke
Co che hao mon duoc dat trong cac class decorator cua trang bi:

- `Sword`: hao mon khi goi `hit()`
- `Shield`: hao mon khi goi `wardOff(int strength)`

Code ben ngoai (Main, Proxy, soldier co ban) van goi `hit()` va `wardOff()` nhu cu, khong can biet bonus hien tai dang giam bao nhieu.

## Cau hinh
Da them trong `src/config/Database.java`:

- `SWORD_ATK_DECAY_PER_USE`: muc giam ATK moi lan danh
- `SWORD_ATK_MIN`: nguong toi thieu cua bonus ATK
- `SHIELD_DEF_DECAY_PER_USE`: muc giam DEF moi lan do don
- `SHIELD_DEF_MIN`: nguong toi thieu cua bonus DEF

## Cach hoat dong
### Sword
- Luc moi trang bi: bonus = `SWORD_ATK`
- Moi lan `hit()`:
1. Dung bonus hien tai de tinh sat thuong.
2. Giam bonus theo `SWORD_ATK_DECAY_PER_USE`.
3. Khong cho bonus thap hon `SWORD_ATK_MIN`.

### Shield
- Luc moi trang bi: bonus = `SHIELD_DEF`
- Moi lan `wardOff()`:
1. Dung bonus hien tai de giam suc tan cong dau vao.
2. Giam bonus theo `SHIELD_DEF_DECAY_PER_USE`.
3. Khong cho bonus thap hon `SHIELD_DEF_MIN`.

## Tinh trong suot
Yeu cau "trong suot voi phan con lai" duoc dap ung vi:

- `SoldierProxy` chi quan ly viec co duoc gan trang bi hay khong.
- Hao mon nam trong trang bi (decorator), khong doi public API cua soldier.
- Main khong can truy cap bien do ben cua equipment.

## Chay demo
Main da cap nhat de mo phong 5 round chien dau sau khi trang bi sword va shield.
Console se in them dong `[Wear] ...` de hien thi bonus hien tai va bonus cho lan tiep theo.

## Ket qua mong doi
- Attack cua sword giam dan theo tung round den muc toi thieu.
- Kha nang phong thu cua shield giam dan theo tung round den muc toi thieu.
- He thong van dung dung luong Proxy + Decorator nhu phan 1.2.
