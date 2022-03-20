# SystemArchitectureDiagram
[SystemArchitectureDiagram drawio (2)](https://user-images.githubusercontent.com/93904514/159162938-23dc6c70-1982-4ea9-a70e-f0134aa7a48c.png)
- งานนี้มีทั้งหมด5ระบบ
  1.  RTCS
      - 5 serviceย่อย
        - RTCSbalance
          - ปรับbalanceบัญชีcash center
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

# Planing & task
- git
  - ได้วางการทำงานไว้ว่า เราจะไม่ใช้ main branch ในการทำแต่จะให้แตก branchออกไปทำแต่ละservice เมื่อจะต้องการmerge จะทำMergeBranchไว้ตามระบบที่ทำเสร็จ ซึ่งจะมี MergeBranch ทั้งหมด4 branch    เมื่อเช็คและรันไม่มีปัญหาในแต่ละระบบ ก็จะนำ4ระบบนั้นมารรันรวมกันที่  branchที่ชื่อว่า MergeFullSystem เพื่อที่จะทดสอบมั้ง4ระบบเมื่อทำงานด้วยกัน และเมื่อทดสอบว่าไม่มีปัญหาจึงค่อยนำไปmergeกับ branch หลัก
  - การทำงานจริง
    - ซึ่งไม่เป็นไปตามที่ได้วางไว้จึงได้ทำการmerge 2 service ที่อยู่ใน RTCS ที่branchชื่อ MergeBranch และทดสอบการรัน MVNในservice แต่ละตัว ต่อมาจึงได้นำไป merge เข้ากับ branchหลัก
- maintainability
  - Docker
    - การทำงานได้วางไว่าทำงานไปทีละ service ย่อยและใส่dockerfile ที่ต่อไปจะทำเป็น dockercontainer และจะรวมdocker container เหล่านั้นด้วย Dockercompose
    - การทำงานจริง
      - ไม่มีระบบในส่วนนี้ และได้ทำ container ไปเพียงตัวเดียวซึ่งไม่มีประโยชน์
- System Performance
  - Asynchronous
    - Rabbit Mq 
      - วางแผนเเพื่อที่จะมาทำqueue ในส่วนของ การจัดกาเร่่องการเงิน balanceต่างๆ FIFO
    - kafka
      - event-based 
        - นำมาทำ messaging ในส่วนของการที่จะนำไปเป้นข้อมูลต่อใน dashboard และ report
- Security
  - Gateway filter
    - ได้วางแผนไว้ว่าจะนำมาเพื่อที่จะเป็น API gate way กรองป้องกัน การโจมตีทางCyberต่างๆ และกำหนดRate limit strategies
  - Data Encryption
    - Symmetric
      - เนื่องจากเป็นข้อมูลด้านการเงินจึงจพเป็นต้องมีเพื่อช่วยในการป้องกันข้อมูล
  - OAuth 2
      - เช็คสิทธิคนใช้งาน
- Observablity
    - jaeger
      - การทำtracingเพื่อจะได้รู้ว้่เกิดปัยหาที่ไหน ทำตามการเรียกใช้งานต่างๆ
    - Centralize log system
      - logstash
        - จัดเก็บlog  ให้เป็น centralized log system
      -  elastic search
      -  kibana
        - monitor log
    - ใช้ log กับ tacing ร่วมกัน เพื่อแก้ไขปัญหาcentralized log  โดยการ add UUID เพื่อตามติด log ได้
