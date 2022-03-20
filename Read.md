# detail of work
- ง่นนี้มีทั้งหมด5ระบบ
  1.  RTCS
      - 5 serviceย่อย
        - RTCSbalance
          - ปรับบัญชีcash center
        - Location
          - รับlocation จาก IOT
        - QRCode
          - ScanQR
          - GenerateQR
        - DashBoard
          - แสดงlocation ของรถ และ Cash center
          - แสดงเงิดสดภายในประเทศ
          - อัตราการแลกเปลี่ยน
        - Report
          - เตรียมไฟล์ข่อมูลอัพเดทยอดเงินสดที่เปลี่ยนแปลง 
  2.  DPTeller
      - รับผิดชอบสาขาย่อย
      - 2 serviceย่อย
         -  QRCode
            - ScanQR
            - GenerateQR
         -  DPTellerBalance
            - จัดการbalance ของสาขาย่อย
  3.  FXHub
      - อัตราแลกเปลี่ยน
      - exchange
  4.  RAE
      - บันทึกอัพเดทยอดเงินสดที่เปลี่ยนแปลง 
