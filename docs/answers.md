# Trả lời Câu Hỏi - Army Game

## Phần 1.1 - Decorator Pattern

### Câu 1
Theo Decorator Pattern, "chức năng của đối tượng trở nên phong phú hơn" - điều này có đúng trong trường hợp này không?

Trả lời:
- Đúng.
- Khi gắn thêm trang bị (`Sword`, `Shield`) bằng Decorator, đối tượng soldier vẫn giữ cùng interface nhưng hành vi được mở rộng.
- Cụ thể:
  - `hit()` có thể tăng sức tấn công.
  - `wardOff()` có thể tăng khả năng phòng thủ.
- Như vậy, không cần sửa class gốc (`Infantry`, `Cavalry`) mà vẫn thêm được chức năng theo kiểu cộng dồn.

### Câu 2
Nếu có ràng buộc "một binh lính không thể mang hai trang bị cùng loại", Decorator có phải là phương pháp thích hợp để đảm bảo ràng buộc này không?

Trả lời:
- Không phải lựa chọn tốt nhất nếu chỉ dùng Decorator thuần.
- Lý do:
  - Decorator mạnh về mở rộng hành vi.
  - Decorator không tối ưu để quản lý ràng buộc nghiệp vụ toàn cục như "không trùng loại".
  - Nếu chỉ bọc decorator chồng lớp, vẫn có thể vô tình gắn hai lần cùng một loại trang bị.
- Cách phù hợp hơn:
  - Dùng `Proxy` (hoặc manager/factory) để kiểm soát policy.
  - Trong bài này, `SoldierProxy` dùng tập `equippedTypes` để chặn trùng lặp.

## Phần 3.2 - Singleton Pattern

### Câu hỏi
Tại sao việc giới hạn mỗi observer (`DeathCountObserver`, `DeathNotifierObserver`) chỉ có một instance lại có ý nghĩa trong bối cảnh theo dõi trận chiến?

Trả lời:
- Để đảm bảo trạng thái theo dõi là nhất quán trong toàn bộ trận chiến.
- Nếu có nhiều instance `DeathCountObserver`:
  - Số lính chết có thể bị đếm phân tán hoặc lệch nhau.
- Nếu có nhiều instance `DeathNotifierObserver`:
  - Có thể phát sinh thông báo/email trùng lặp.
- Singleton giúp:
  - Có một "nguồn sự thật" duy nhất cho đếm tử trận và thông báo tử trận.
  - Dễ kiểm soát vòng đời đối tượng observer.
  - Tránh lỗi logic do trùng trạng thái giữa nhiều bản sao observer.
